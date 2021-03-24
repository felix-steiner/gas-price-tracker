package com.gaspricetracker.gaspricetracker.database;

import org.springframework.beans.factory.annotation.Value;

public interface PriceEntry {
    Double getPrice();

    @Value("#{target.created_at}")
    long getCreatedAt();
}
