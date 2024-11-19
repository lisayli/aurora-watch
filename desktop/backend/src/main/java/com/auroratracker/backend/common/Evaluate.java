package com.auroratracker.backend.common;

import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.models.space.weatherfactors.SolarWind;

public interface Evaluate
{
    String evaluateAurora(KPIndex kpIndex, SolarWind speed, IMFData bz);
}
