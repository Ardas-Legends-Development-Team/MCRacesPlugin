package com.jukoz.races.EventListeners;

import com.jukoz.races.Repository.PlayerGroupsManager;
import com.jukoz.races.Repository.RacesGroup;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class OnPlayerAttack implements Listener {
    private final float ORC_LIFE_STEAL = 0.05f;
    private final float HUMAN_DAMAGE_BUFF = 1.1f;
    private final int HUMAN_HEALTH_TRIGGER = 5;

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() == EntityType.PLAYER) {
            Player attacker = (Player) event.getDamager();
            RacesGroup group = PlayerGroupsManager.getGroupFromPlayer(attacker);

            if (group == RacesGroup.HUMAN) {
                if (attacker.getHealth() < HUMAN_HEALTH_TRIGGER) {
                    event.setDamage(event.getDamage() * HUMAN_DAMAGE_BUFF); // If human below 5 hearts, deals more damage (adrenaline)
                }
            } else if (group == RacesGroup.ORC) {
                attacker.setHealth(attacker.getHealth() + (event.getFinalDamage() * ORC_LIFE_STEAL)); // Life steal
            }
        }
    }
}