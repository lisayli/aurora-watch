package com.auroratracker.backend.services;

import com.auroratracker.backend.dtos.AuroraDataDTO;

import com.auroratracker.backend.models.space.weatherfactors.Dst;
import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import com.auroratracker.backend.services.weatherfactors.DstService;
import com.auroratracker.backend.services.weatherfactors.IMFService;
import com.auroratracker.backend.services.weatherfactors.KPIndexService;
import com.auroratracker.backend.services.weatherfactors.SolarWindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuroraService {
    /*
    TODO: skapa Aurora prediction i varje service och använd i denna method.
    TODO: skriv unit tester
     */
    private final KPIndexService kpIndexService;
    private final SolarWindService solarWindService;
    private final IMFService imfService;
    private final DstService dstService;

    @Autowired
    public AuroraService(KPIndexService kpIndexService, SolarWindService solarWindService, IMFService imfService, DstService dstService) {
        this.kpIndexService = kpIndexService;
        this.solarWindService = solarWindService;
        this.imfService = imfService;
        this.dstService = dstService;
    }


    public AuroraDataDTO calculateAuroraPrediction() {
        KPIndex kpIndex = kpIndexService.fetchLatestKpIndex();
        SolarWind solarWind = solarWindService.fetchLatestSolarWind();
        IMFData imfData = imfService.fetchLatestIMFData();
        Dst dst = dstService.fetchLatestDstData();

        double countScore = AuroraScoreCalculator.countAuroraScore(kpIndex, solarWind, imfData, dst);
        String scoreAnalysis = AuroraScoreCalculator.analyseAuroraScore(countScore);

        AuroraDataDTO result =  new AuroraDataDTO();

        result.setKpIndex(kpIndex.getValue());
        result.setSolarWindSpeed(solarWind.getSpeed());
        result.setSolarWindDensity(solarWind.getDensity());
        result.setImfBz(imfData.getBz());
        result.setDst(dst.getValue());
        result.setAnalysis(scoreAnalysis);

        System.out.println("Score: " + countScore);
     
        return result;
    }


}
