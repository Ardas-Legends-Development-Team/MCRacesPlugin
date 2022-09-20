package com.jukoz.races.EventListeners;

import com.jukoz.races.Repository.PlayerGroupsManager;
import com.jukoz.races.Repository.RacesGroup;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnTakeDamage implements Listener {

    @EventHandler
    public void onEntityDamage (EntityDamageEvent event) {
        if(event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            RacesGroup group = PlayerGroupsManager.getGroupFromPlayer(player);

            if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(group == RacesGroup.ELF) {
                    event.setDamage(event.getDamage() * 0.7f);
                }
            }
            if(group == RacesGroup.DWARF) {
                event.setDamage(event.getDamage() * 0.95f);
            } else if(group == RacesGroup.TROLL) {
                event.setDamage(event.getDamage() * 0.8f);
            } else if(group == RacesGroup.WIZARD || group == RacesGroup.NAZGUL) {
                event.setDamage(event.getDamage() * 0.9f);
            }
        }
    }
}
