package com.jukoz.racesplugin.Races;

import com.jukoz.racesplugin.RaceEffect;
import com.jukoz.racesplugin.RaceEffects.OrcEffect;

public class Orc extends AbstractRace{

    private static Orc instance;
    public static final RaceEffect ORC_EFFECT = new OrcEffect();
    public static final AvailableRacesEnum ORC_NAME = AvailableRacesEnum.ORC;


    private Orc(){
        super(ORC_EFFECT, ORC_NAME);
    }

    public static Orc getInstance(){
        if (instance==null){
            instance=new Orc();
        }
        return instance;
    }
}
