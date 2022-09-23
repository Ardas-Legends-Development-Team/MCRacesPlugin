package com.jukoz.racesplugin.RaceEffects;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class OrcEffect extends AbstractRaceEffect{
    public static final int ORC_BONUS_DAMAGE = 0;
    public static final int ORC_BONUS_HEALTH = 0;

    public OrcEffect () {
        super(ORC_BONUS_DAMAGE, ORC_BONUS_HEALTH);
    }

    @Override
    public void onKill(PlayerDeathEvent event) {

    }

    @Override
    public void onShootBow(EntityShootBowEvent event) {

    }

    @Override
    public void onEat(PlayerItemConsumeEvent event) {

    }

    @Override
    public void onPlayerAttack(EntityDamageByEntityEvent event) {

    }

    @Override
    public void onTakeDamage(EntityDamageEvent event) {

    }

    @Override
    public void passiveEffect(Player player) {

    }
}
