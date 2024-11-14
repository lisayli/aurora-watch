package com.auroratracker.backend.models.space.weatherfactors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KPIndex  {
    private double value;
    private String timeTag;

    public KPIndex(double value, String timeTag) {
        this.value = value;
        this.timeTag = timeTag;
    }
     public KPIndex() {}

    public KPIndex(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Kp-index: " + value + "<br>" + "Date & Time: " + timeTag;
    }



}
