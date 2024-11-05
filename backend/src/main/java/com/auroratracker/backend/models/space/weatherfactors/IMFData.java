package com.auroratracker.backend.models.space.weatherfactors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IMFData {

    private double bt;
    private double bz;

    public IMFData(double bt, double bz) {
        this.bt = bt;
        this.bz = bz;
    }

    @Override
    public String toString() {
        return "ImfData { " + "<br>" + "Bt: " +  bt + "<br>" + "bz: " + bz + "<br>" + "}";
    }
}
