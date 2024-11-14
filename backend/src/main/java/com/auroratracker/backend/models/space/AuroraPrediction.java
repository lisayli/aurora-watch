package com.auroratracker.backend.models.space;


import com.auroratracker.backend.common.Evaluate;
import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;

import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuroraPrediction implements Evaluate {
    private final KPIndex kpIndex;
    /*  private final SolarWind solarWind;
      private  final Dst dst;
      private final IMFData imfData;
       */
    private String timeTag;


    public AuroraPrediction(KPIndex kpIndex, String timeTag) {
        this.kpIndex = kpIndex;
        this.timeTag = timeTag;
    }

    @Override
    public String toString() {
        return "Kp: " + kpIndex + "\n";
    }

    @Override
    public String evaluateAurora(KPIndex kpIndex, SolarWind speed, IMFData bz) {
        if (kpIndex.getValue() <= 2 || speed.getSpeed() <= 400 || bz.getBz() > 0) {
            return "unfortunately! no chance of aurora at the moment";
        }
        if (kpIndex.getValue() >= 3 || speed.getSpeed() >= 500 || bz.getBz() < -5) {
        }
        return "Big chance to see Aurora!!";
    }
}
