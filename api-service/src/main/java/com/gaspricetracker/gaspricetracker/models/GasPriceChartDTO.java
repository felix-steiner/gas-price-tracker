package com.gaspricetracker.gaspricetracker.models;

import java.util.List;

public class GasPriceChartDTO {
    String name;
    String city;
    Double lat;
    Double lon;
    List<GasPriceDTO> gasPriceDTOS;

    public GasPriceChartDTO(String name, String city, Double lat, Double lon, List<GasPriceDTO> gasPriceDTOS) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.gasPriceDTOS = gasPriceDTOS;
    }

    public GasPriceChartDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public List<GasPriceDTO> getGasPriceDTOS() {
        return gasPriceDTOS;
    }

    public void setGasPriceDTOS(List<GasPriceDTO> gasPriceDTOS) {
        this.gasPriceDTOS = gasPriceDTOS;
    }
}
