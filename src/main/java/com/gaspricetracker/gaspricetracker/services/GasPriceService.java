package com.gaspricetracker.gaspricetracker.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaspricetracker.gaspricetracker.models.GasStationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class GasPriceService {

    private HttpClient httpClient;
    ObjectMapper objectMapper;
    private final String apiEndpoint = "https://www.vol.at/api/services/get_gas_stations";

    @Value("${fuel}")
    private String fuel;
    @Value("${lat}")
    private String lan;
    @Value("${lon}")
    private String lon;

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
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode jsonResponse = objectMapper.readTree(response.body());
            String gasStations = jsonResponse.get("gasstations").toString();
            GasStationDTO[] gasStationDTOS = objectMapper.readValue(gasStations, GasStationDTO[].class);
            for (var gasStation : gasStationDTOS) {
                System.out.println(gasStation.getName());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
