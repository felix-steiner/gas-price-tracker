package com.gaspricetracker.gaspricetracker.database;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gas_prices")
public class GasPriceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "created_at")
    Timestamp createdAt;
    String name;
    @Column(name = "company_name")
    String companyName;
    String zipcode;
    String city;
    String street;
    double lat;
    double lon;
    @Column(name = "diesel_price")
    double dieselPrice;
    @Column(name = "petrol_price")
    double petrolPrice;

    public GasPriceEntry(String name, String companyName, String zipcode, String city, String street, double lat, double lon, double dieselPrice, double petrolPrice) {
        this.name = name;
        this.companyName = companyName;
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.lat = lat;
        this.lon = lon;
        this.dieselPrice = dieselPrice;
        this.petrolPrice = petrolPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return createdAt;
    }

    public void setTimestamp(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public double getPetrolPrice() {
        return petrolPrice;
    }

    public void setPetrolPrice(double petrolPrice) {
        this.petrolPrice = petrolPrice;
    }
}
