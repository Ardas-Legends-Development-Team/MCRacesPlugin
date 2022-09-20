package com.jukoz.races.EventListeners;

import com.jukoz.races.Repository.PlayerGroupsManager;
import com.jukoz.races.Repository.RacesGroup;
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
            RacesGroup group = PlayerGroupsManager.getGroupFromPlayer(player);

            if (group == RacesGroup.ELF) {
                Projectile arrow = (Projectile) event.getProjectile();
                Vector velocity = arrow.getVelocity().multiply(1.5f);
                arrow.setVelocity(velocity);
            }
        }
    }
}
