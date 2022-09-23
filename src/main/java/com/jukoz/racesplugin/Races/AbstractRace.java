package com.jukoz.racesplugin.Races;

import com.jukoz.racesplugin.Race;
import com.jukoz.racesplugin.RaceEffect;

public abstract class AbstractRace implements Race {
    private final RaceEffect raceEffect;
    private final AvailableRacesEnum name;

    public AbstractRace(RaceEffect effect, AvailableRacesEnum name){
        this.raceEffect=effect;
        this.name=name;
    }

    @Override
    public RaceEffect getRaceEffect() {
        return raceEffect;
    }

    @Override
    public AvailableRacesEnum getName() {
        return name;
    }
}
