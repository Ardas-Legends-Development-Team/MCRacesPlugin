package com.jukoz.racesplugin.EventListeners;

import com.jukoz.racesplugin.Repository.PlayerGroupsManager;
import com.jukoz.racesplugin.Races.AvailableRacesEnum;
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
            AvailableRacesEnum group = PlayerGroupsManager.getRaceEnumFromPlayer(player);

            if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(group == AvailableRacesEnum.ELF) {
                    event.setDamage(event.getDamage() * 0.7f);
                }
            }
            if(group == AvailableRacesEnum.DWARF) {
                event.setDamage(event.getDamage() * 0.95f);
            } else if(group == AvailableRacesEnum.TROLL) {
                event.setDamage(event.getDamage() * 0.8f);
            } else if(group == AvailableRacesEnum.WIZARD || group == AvailableRacesEnum.NAZGUL) {
                event.setDamage(event.getDamage() * 0.9f);
            }
        }
    }
}
