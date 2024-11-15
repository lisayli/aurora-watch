package com.auroratracker.backend;


import com.auroratracker.backend.models.space.weatherfactors.Dst;
import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import com.auroratracker.backend.services.AuroraScoreCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuroraPredicTest {


    /*

    @Test
    void testHighChanceOfAuroraShouldReturnScore5() {
        KPIndex kpIndex = new KPIndex(5); // Initiera med korrekt värde 5
        double expectedScore = 5.0;

      //  double actualScore = AuroraScoreCalculator.countAuroraScore(kpIndex);

  //      assertEquals(expectedScore, actualScore, "Score should be 5 for KpIndex >= 5");
    }

    @Test
    void testMiddleChanceOfAuroraShouldReturnScore() {
        KPIndex kpIndex = new KPIndex(4.9); // Initiera med korrekt värde 5
        double expectedScore = 3;

//double actualScore = AuroraScoreCalculator.countAuroraScore(kpIndex);

  //      assertEquals(expectedScore, actualScore, "Score should be 3 for KpIndex >= 3");
    }

 */

   /* KPIndex kpIndex;
    SolarWind solarWind;
    IMFData imfData;
    Dst dst;
    @Test
    void testAuroraPredictionWithHighResult(){
        kpIndex = new KPIndex(6);
        solarWind = new SolarWind(600,-50);
        imfData = new IMFData(2,-12);
        dst = new Dst(-60);

        double score = AuroraScoreCalculator.countAuroraScore(kpIndex,solarWind,imfData,dst);
        double actualScore = 12;

        assertEquals(actualScore,score);

    }

    */

}
