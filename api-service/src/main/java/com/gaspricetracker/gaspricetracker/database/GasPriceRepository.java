package com.gaspricetracker.gaspricetracker.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GasPriceRepository extends JpaRepository<GasPriceEntry, Integer> {
    @Query(value = "SELECT DISTINCT name, city, lat, lon FROM gas_prices;", nativeQuery = true)
    List<UniqueGasStationEntry> findGasStations();

    @Query(value = "SELECT price, created_at FROM gas_prices WHERE name = ?1 AND lat = ?2 AND lon = ?3", nativeQuery = true)
    List<PriceEntry> findPricesByGasStation(String name, Double lat, Double lon);
}
