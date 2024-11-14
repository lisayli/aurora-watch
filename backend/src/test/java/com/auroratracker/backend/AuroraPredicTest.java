package com.auroratracker.backend;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.services.AuroraService;
import com.auroratracker.backend.services.weatherfactors.KPIndexService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuroraPredicTest {

    @Mock
    private KPIndexService kpIndexService;

    @InjectMocks
    private AuroraService auroraService;


    @Test
    void highChanceOfAuroraShould_KPIndex() {
        when(kpIndexService.fetchLatestKpIndex()).thenReturn(new KPIndex(5));

    }
}
