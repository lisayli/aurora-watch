package com.auroratracker.backend;

import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.services.AuroraScoreCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {




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

}
