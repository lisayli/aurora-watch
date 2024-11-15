package com.auroratracker.backend.services;

import com.auroratracker.backend.models.space.weatherfactors.Dst;
import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.models.space.weatherfactors.SolarWind;

public class AuroraScoreCalculator {
// , SolarWind solarWind, IMFData imfData, Dst dst

    /**
     * +5 = hög chans
     */
    public static double countAuroraScore(KPIndex kpIndex, SolarWind speed, IMFData imfDataBZ, Dst dst) {
        double score = 0;

        if (kpIndex.getValue() >= 5) {
            // hög chans
            score += 5;
        } else if (kpIndex.getValue() >= 3) {
            score += 3;
        } else {
            score += 1;
        }

        if (speed.getSpeed() >= 500) {
            score += 4;
        } else if (speed.getSpeed() >= 400) {
            score += 2;
        } else {
            score += 1;
        }

        if (imfDataBZ.getBz() <= -10) {
            score += 5;
        } else if (imfDataBZ.getBz() <= -5) {
            score += 3;
        } else {
            score += 0;
        }

        if (dst.getValue() <= -50) {
            score += 4;
        } else if (dst.getValue() <= 30) {
            score += 2;
        } else {
            score += 0;
        }

        return score;
    }

    protected static String analyseAuroraScore(double score) {
        if (score > 12) {
            return "High Chance Of Aurora!";
        } else if (score > 6) {
            return "Middle Chance Of Aurora!";
        } else  {
            return "Low Chance Of Aurora!";
        }
    }
}
