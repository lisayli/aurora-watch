package com.auroratracker.backend.controllers.weatherfactors;

import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import com.auroratracker.backend.services.weatherfactors.SolarWindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/aurora")
public class SolarWindController {
    private final SolarWindService solarWindService;


    @Autowired
    public SolarWindController(SolarWindService solarWindService) {
        this.solarWindService = solarWindService;
    }

    @GetMapping("/solar-wind")
    public ResponseEntity<SolarWind> getSolarWindData() {
        SolarWind solarWind = solarWindService.fetchLatestSolarWind();

        if (solarWind != null) {
            System.out.println("Solar wind Speed: " + solarWind.getSpeed() + " km/s\nDensity " +
                    solarWind.getDensity());
            return ResponseEntity.ok(solarWind);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
