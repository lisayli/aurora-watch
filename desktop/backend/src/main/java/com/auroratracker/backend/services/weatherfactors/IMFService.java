package com.auroratracker.backend.services.weatherfactors;

import com.auroratracker.backend.common.DateAndTime;
import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class IMFService {

    private static final String NOAA_API_IMF_DATA_URL = "https://services.swpc.noaa.gov/json/rtsw/rtsw_mag_1m.json";
    private static final Logger logger = LoggerFactory.getLogger(IMFService.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public IMFService() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    public IMFData fetchLatestIMFData() {
        try {
            String jsonResponse = restTemplate.getForObject(NOAA_API_IMF_DATA_URL, String.class);

            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
            JsonNode latestData = rootNode.get(0);
            double bt = latestData.get("bt").asDouble();
            double bz = latestData.get("bz_gsm").asDouble();
            String timeTag = DateAndTime.getCurrentDateAndTimeFormatted();

            return new IMFData (bt, bz);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching KP Index data from NOAA API", e);
        }
    }

/*
    private Optional<String> fetchApiData() {
        try {
            return Optional.ofNullable(restTemplate.getForObject(NOAA_API_IMF_DATA_URL, String.class));
        } catch (Exception e) {
            logger.error("Error fetching IMF data från NOAA API", e);
            return Optional.empty();
        }
    }

    private Optional<IMFData> parseIMFData(String jsonData) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode latestData = rootNode.get(0);
            double bt = latestData.get("bt").asDouble();
            double bz = latestData.get("bz_gsm").asDouble();
            return Optional.of(new IMFData(bt, bz));
        } catch (Exception e) {
            logger.error("Error parsing KP Index data", e);
            return Optional.empty();
        }
    }

 */
}
