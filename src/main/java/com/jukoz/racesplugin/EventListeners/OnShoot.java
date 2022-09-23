package com.jukoz.racesplugin.EventListeners;

import com.jukoz.racesplugin.Repository.PlayerGroupsManager;
import com.jukoz.racesplugin.Races.AvailableRacesEnum;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

public class OnShoot implements Listener {

    @EventHandler
    public void EntityShootBowEvent(EntityShootBowEvent event) {
        if(event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            AvailableRacesEnum group = PlayerGroupsManager.getRaceEnumFromPlayer(player);

            if (group == AvailableRacesEnum.ELF) {
                Projectile arrow = (Projectile) event.getProjectile();
                Vector velocity = arrow.getVelocity().multiply(1.5f);
                arrow.setVelocity(velocity);
            }
        }
    }
}
