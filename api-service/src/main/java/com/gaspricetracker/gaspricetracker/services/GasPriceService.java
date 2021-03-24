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

    @Scheduled(fixedRateString = "${rate}")
    public void requestGasPrices() {
        String url = String.format("%s?fuel=DIE&devicePosition[lat]=%s&devicePosition[lon]=%s", apiEndpoint, lan, lon);
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
                    .forEach(this::createGasPriceEntry);
        } catch (IOException | InterruptedException e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
        }
    }

    private void createGasPriceEntry(GasPriceEntry gasPriceEntry) {
        if(gasPriceEntry.getPrice() == 0) return;
        logger.info("Storing " + gasPriceEntry.getName() + " to database");
        gasPriceRepository.save(gasPriceEntry);
    }

    public List<GasPriceEntry> readGasPriceEntries() {
        return gasPriceRepository.findAll();
    }

    private GasPriceEntry convertDTOtoEntry(GasStationDTO gasStationDTO) {
        return new GasPriceEntry(
                gasStationDTO.getName(),
                gasStationDTO.getCompanyName(),
                gasStationDTO.getZipcode(),
                gasStationDTO.getCity(),
                gasStationDTO.getStreet(),
                gasStationDTO.getPoint().getLat(),
                gasStationDTO.getPoint().getLon(),
                gasStationDTO.getPrice() != null ? gasStationDTO.getPrice() : 0
        );
    }
}
