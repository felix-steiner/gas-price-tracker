package com.gaspricetracker.gaspricetracker.controllers;

import com.gaspricetracker.gaspricetracker.database.GasPriceEntry;
import com.gaspricetracker.gaspricetracker.models.GasPriceChartDTO;
import com.gaspricetracker.gaspricetracker.services.GasPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GasPriceController {

    @Autowired
    private GasPriceService gasPriceService;

    @GetMapping("/gas-prices")
    public List<GasPriceEntry> getGasPrices() {
        return gasPriceService.readGasPriceEntries();
    }

    @GetMapping("/gas-prices/chart")
    public List<GasPriceChartDTO> getGasPricesForChart() {
        return gasPriceService.readGasPriceEntriesForChart();
    }
}
