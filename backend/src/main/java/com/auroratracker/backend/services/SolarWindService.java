package com.auroratracker.backend.services;


import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SolarWindService {

    private static final String NOAA_API_SOLAR_WIND_URL = "https://services.swpc.noaa.gov/json/rtsw/rtsw_wind_1m.json";
    private static final Logger logger = LoggerFactory.getLogger(SolarWindService.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    public SolarWindService() {

        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }


    private Optional<String> fetchApiData() {
        try {
            return Optional.ofNullable(restTemplate.getForObject(NOAA_API_SOLAR_WIND_URL, String.class));
        } catch (Exception e) {
            logger.error("Error fetching Solar Wind data from NOAA API", e);
            return Optional.empty();
        }
    }

    public Optional<SolarWind> fetchLatestSolarWind() {
        return fetchApiData()
                .flatMap(this::parseSolarWindData);
    }

    private Optional<SolarWind> parseSolarWindData(String jsonData) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode latestData = rootNode.get(0);
            double speed = latestData.get("proton_speed").asDouble();
            double density = latestData.get("proton_density").asDouble();
            return Optional.of(new SolarWind(speed, density));
        } catch (Exception e) {
            logger.error("Error parsing Solar Wind data", e);
            return Optional.empty();
        }
    }
}
