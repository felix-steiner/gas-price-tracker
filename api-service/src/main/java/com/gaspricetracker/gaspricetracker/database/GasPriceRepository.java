package com.gaspricetracker.gaspricetracker.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GasPriceRepository extends JpaRepository<GasPriceEntry, Integer> {
}
