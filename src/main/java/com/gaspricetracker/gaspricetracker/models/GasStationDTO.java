package com.gaspricetracker.gaspricetracker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GasStationDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("companyName")
    private Object companyName;
    @JsonProperty("updatedOn")
    private Integer updatedOn;
    @JsonProperty("street")
    private String street;
    @JsonProperty("zipcode")
    private Integer zipcode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("point")
    private PointDTO point;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("distanceFormatted")
    private String distanceFormatted;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("url")
    private String url;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("phoneFormatted")
    private String phoneFormatted;
    @JsonProperty("openingTimes")
    private List<OpeningTimeDTO> openingTimes = null;
    @JsonProperty("opened")
    private Boolean opened;
    @JsonProperty("fuel")
    private String fuel;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("priceFormatted")
    private String priceFormatted;
    @JsonProperty("paymentMethods")
    private List<String> paymentMethods = null;
    @JsonProperty("paymentCards")
    private Object paymentCards;
    @JsonProperty("chargingStation")
    private Object chargingStation;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("companyName")
    public Object getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("updatedOn")
    public Integer getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updatedOn")
    public void setUpdatedOn(Integer updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("zipcode")
    public Integer getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("point")
    public PointDTO getPoint() {
        return point;
    }

    @JsonProperty("point")
    public void setPoint(PointDTO point) {
        this.point = point;
    }

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("distanceFormatted")
    public String getDistanceFormatted() {
        return distanceFormatted;
    }

    @JsonProperty("distanceFormatted")
    public void setDistanceFormatted(String distanceFormatted) {
        this.distanceFormatted = distanceFormatted;
    }

    @JsonProperty("mail")
    public String getMail() {
        return mail;
    }

    @JsonProperty("mail")
    public void setMail(String mail) {
        this.mail = mail;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("phoneFormatted")
    public String getPhoneFormatted() {
        return phoneFormatted;
    }

    @JsonProperty("phoneFormatted")
    public void setPhoneFormatted(String phoneFormatted) {
        this.phoneFormatted = phoneFormatted;
    }

    @JsonProperty("openingTimes")
    public List<OpeningTimeDTO> getOpeningTimes() {
        return openingTimes;
    }

    @JsonProperty("openingTimes")
    public void setOpeningTimes(List<OpeningTimeDTO> openingTimes) {
        this.openingTimes = openingTimes;
    }

    @JsonProperty("opened")
    public Boolean getOpened() {
        return opened;
    }

    @JsonProperty("opened")
    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    @JsonProperty("fuel")
    public String getFuel() {
        return fuel;
    }

    @JsonProperty("fuel")
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("priceFormatted")
    public String getPriceFormatted() {
        return priceFormatted;
    }

    @JsonProperty("priceFormatted")
    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    @JsonProperty("paymentMethods")
    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    @JsonProperty("paymentMethods")
    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @JsonProperty("paymentCards")
    public Object getPaymentCards() {
        return paymentCards;
    }

    @JsonProperty("paymentCards")
    public void setPaymentCards(Object paymentCards) {
        this.paymentCards = paymentCards;
    }

    @JsonProperty("chargingStation")
    public Object getChargingStation() {
        return chargingStation;
    }

    @JsonProperty("chargingStation")
    public void setChargingStation(Object chargingStation) {
        this.chargingStation = chargingStation;
    }
}
