package com.auroratracker.backend.services.weatherfactors;

import com.auroratracker.backend.common.DateAndTime;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KPIndexService {

    private static final String NOAA_API_KP_INDEX_URL = "https://services.swpc.noaa.gov/json/planetary_k_index_1m.json";
    private static final Logger logger = LoggerFactory.getLogger(KPIndexService.class);
    private final RestTemplate restTemplate;


    public KPIndexService() {
        this.restTemplate = new RestTemplate();

    }

    public KPIndex fetchLatestKpIndex() {
        try {
            String jsonResponse = restTemplate.getForObject(NOAA_API_KP_INDEX_URL, String.class);

            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
            JsonNode latestData = rootNode.get(rootNode.size() - 1);
            double kpIndexValue = latestData.get("kp_index").asDouble();
            String timeTag = DateAndTime.getCurrentDateAndTimeFormatted();

            return new KPIndex(kpIndexValue, timeTag);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching KP Index data from NOAA API", e);
        }
    }
/*
    private Optional<String> fetchApiData() {
        try {
            return Optional.ofNullable(restTemplate.getForObject(NOAA_API_KP_INDEX_URL, String.class));
        } catch (Exception e) {
            logger.error("Error fetching KP Index data from NOAA API", e);
            return Optional.empty();
        }
    }

 */
/*
    private Optional<KPIndex> parseKpIndex(String jsonData) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode latestData = rootNode.get(rootNode.size() - 1);
            double value = latestData.get("kp_index").asDouble();
            return Optional.of(new KPIndex(value));
        } catch (Exception e) {
            logger.error("Error parsing KP Index data", e);
            return Optional.empty();
        }
    }

 */


}
