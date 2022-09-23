package com.jukoz.racesplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public interface RaceEffect {
    void onKill(PlayerDeathEvent event);
    void onShootBow(EntityShootBowEvent event);
    void onEat(PlayerItemConsumeEvent event);
    void onPlayerAttack(EntityDamageByEntityEvent event);
    void onTakeDamage(EntityDamageEvent event);
    void passiveEffect(Player player);
}
