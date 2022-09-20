package com.jukoz.races.EventListeners;

import com.jukoz.races.Repository.PlayerGroupsManager;
import com.jukoz.races.Repository.RacesGroup;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class EntityShootBowEvent implements Listener {

    @EventHandler
    public void EntityShootBowEvent(org.bukkit.event.entity.EntityShootBowEvent event) {
        ItemStack bow = event.getBow();
        Entity shooter = event.getEntity();
        if(bow.getType().toString().contains("BOW") && shooter.getType() == EntityType.PLAYER) {
            Player player = (Player) shooter;
            RacesGroup group = PlayerGroupsManager.getGroupFromPlayer(player);

            if(bow.getType().toString().contains("BOW") && !bow.getType().toString().contains("CROSS")) {
                if(group == RacesGroup.DWARF) {
                    player.sendMessage("You cannot use a bow!");
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1f, 1f);
                    event.getProjectile().remove();
                }
            }

            if(bow.getType().toString().contains("CROSS")) {
                if(group == RacesGroup.ELF) {
                    player.sendMessage("You cannot use a crossbow!");
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1f, 1f);
                    event.getProjectile().remove();
                }
            }
        }
    }
}
