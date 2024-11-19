package com.auroratracker.backend.models.space.weatherfactors;

import lombok.Getter;
import lombok.Setter;

/**
 * Disturbance Storm Time-index (DST-index)
 * mäts i nT (nanotesla)
 * När laddade partiklar från solen när jordens magnetfält, kan det orsaka en geomagnetisk storm.
 * Dst-indexet visar hur stark denna påverkan är genom att visa en avvikelse i magnetfältet.
 * ett lägre (mer negativt) Dst-värde innebär att jordens magnetfält är mer påverkat, och ju mer negativt det är, desto
 * starkare är stormen
 * ::
 * Range för Dst:
 * 0 till -50 nT: Normal aktivitet.
 * -50 till -100 nT: Svag geomagnetisk storm.
 * Under -100 nT: Stark geomagnetisk storm (vanligtvis ökar chansen för norrsken).
 * ::
 * Ett Dst-värde under -50 nT kan vara en signal på att norrsken är synligt, särskilt
 * om andra faktorer som solvindshastighet och IMF också är gynnsamma.
 */

@Getter
@Setter
public class Dst {

    double value;


    public Dst(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Dst index: " + value;
    }
}
