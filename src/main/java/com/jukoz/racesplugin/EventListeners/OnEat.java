package com.jukoz.racesplugin.EventListeners;

import com.jukoz.racesplugin.Repository.PlayerGroupsManager;
import com.jukoz.racesplugin.Races.AvailableRacesEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnEat implements Listener {

    @EventHandler
    public void PlayerItemConsumeEvent(PlayerItemConsumeEvent event) {
        if (isMeat(event.getItem().toString())) {
            Player player = event.getPlayer();
            AvailableRacesEnum group = PlayerGroupsManager.getRaceEnumFromPlayer(player);
            if (group == AvailableRacesEnum.ELF) {
                event.setCancelled(true);
                player.sendMessage("You are sick from meat!");
                //player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 600, 99));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 0));
            }
        }
    }

    public boolean isMeat(String name) {
        if(name.contains("MEAT")) return true;
        if(name.contains("COOKED")) return true;
        return name.contains("RAW");
    }
}
