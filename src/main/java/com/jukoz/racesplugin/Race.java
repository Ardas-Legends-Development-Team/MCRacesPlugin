package com.jukoz.racesplugin;

import com.jukoz.racesplugin.Races.AvailableRacesEnum;

public interface Race {
    AvailableRacesEnum getName();
    RaceEffect getRaceEffect();
}
