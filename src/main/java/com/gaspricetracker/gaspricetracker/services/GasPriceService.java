package com.gaspricetracker.gaspricetracker.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaspricetracker.gaspricetracker.database.GasPriceEntry;
import com.gaspricetracker.gaspricetracker.database.GasPriceRepository;
import com.gaspricetracker.gaspricetracker.models.GasStationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

@Component
public class GasPriceService {
    private final Logger logger = LoggerFactory.getLogger(GasPriceService.class);

    private HttpClient httpClient;
    ObjectMapper objectMapper;
    private final String apiEndpoint = "https://www.vol.at/api/services/get_gas_stations";

    @Value("${fuel}")
    private String fuel;
    @Value("${lat}")
    private String lan;
    @Value("${lon}")
    private String lon;

    @Autowired
    private GasPriceRepository gasPriceRepository;

    public GasPriceService() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        this.objectMapper = new ObjectMapper();
    }

    @Scheduled(fixedRate = 10000)
    public void requestGasPrices() {
        String url = String.format("%s?fuel=%s&devicePosition[lat]=%s&devicePosition[lon]=%s", apiEndpoint, fuel, lan, lon);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            logger.info("Requesting gas prices");
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String gasStations = objectMapper
                    .readTree(response.body())
                    .get("gasstations").toString();

            objectMapper
                    .readValue(gasStations, new TypeReference<List<GasStationDTO>>() {
                    })
                    .stream()
                    .map(this::convertDTOtoEntry)
                    .forEach(this::storeEntry);
        } catch (IOException | InterruptedException e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
        }
    }

    private GasPriceEntry convertDTOtoEntry(GasStationDTO gasStationDTO) {
        Double price = gasStationDTO.getPrice();
        double dieselPrice = fuel.equals("DIE") && price != null ? price : 0;
        double petrolPrice = fuel.equals("SUP") && price != null ? price : 0;
        return new GasPriceEntry(
                gasStationDTO.getName(),
                gasStationDTO.getCompanyName(),
                gasStationDTO.getZipcode(),
                gasStationDTO.getCity(),
                gasStationDTO.getStreet(),
                gasStationDTO.getPoint().getLat(),
                gasStationDTO.getPoint().getLon(),
                dieselPrice,
                petrolPrice
        );
    }

    private void storeEntry(GasPriceEntry gasPriceEntry) {
        logger.info("Storing " + gasPriceEntry.getName() + " to database...");
        gasPriceRepository.save(gasPriceEntry);
    }
}
