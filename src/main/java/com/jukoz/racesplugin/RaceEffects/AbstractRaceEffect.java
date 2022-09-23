package com.jukoz.racesplugin.RaceEffects;

import com.jukoz.racesplugin.RaceEffect;

public abstract class AbstractRaceEffect implements RaceEffect {
    private final int bonusDamage;
    private final int bonusHealth;


    public AbstractRaceEffect(int bonusDamage, int bonusHealth) {
        this.bonusDamage = bonusDamage;
        this.bonusHealth = bonusHealth;
    }
}
