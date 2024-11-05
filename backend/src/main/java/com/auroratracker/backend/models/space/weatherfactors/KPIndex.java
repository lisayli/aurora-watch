package com.auroratracker.backend.models.space.weatherfactors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KPIndex {
    private double value;

    public KPIndex(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Kp-index: " + value;
    }
}
