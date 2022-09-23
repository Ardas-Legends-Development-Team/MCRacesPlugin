package com.jukoz.racesplugin.EventListeners;

import com.jukoz.racesplugin.Repository.PlayerGroupsManager;
import com.jukoz.racesplugin.Races.AvailableRacesEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnKill implements Listener {
    static final int HUMAN_KILL_BUFF_TIME = 400;

    @EventHandler
    public void onKill(PlayerDeathEvent e)
    {
        Player killer = e.getEntity().getKiller();

        AvailableRacesEnum group = PlayerGroupsManager.getRaceEnumFromPlayer(killer);

        if (group == AvailableRacesEnum.HUMAN) {
            killer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, HUMAN_KILL_BUFF_TIME, 0));
            killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, HUMAN_KILL_BUFF_TIME, 0));
        }
    }
}
