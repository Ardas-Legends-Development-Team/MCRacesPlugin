package com.jukoz.races.LoopTasks;

import com.jukoz.races.Repository.PlayerGroupsManager;
import com.jukoz.races.Repository.RacesGroup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PassiveEffects {
    public static int effectTime = 470;

    public void applyEffectsToAllPlayers() {
        for(Player player : Bukkit.getOnlinePlayers()){
            RacesGroup group = PlayerGroupsManager.getGroupFromPlayer(player);

            switch(group) {
                case ELF:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, effectTime, 0));
                    player.setMaxHealth(24D);
                    break;
                case DWARF:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, effectTime, 0));
                    player.setMaxHealth(20D);
                case HOBBIT:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, effectTime, 1));
                    break;
                case ORC:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, effectTime, 0));
                    break;
                case URUK:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, effectTime, 0));
                    break;
                case TROLL:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, effectTime, 0));
                    break;
                case NAZGUL:
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, effectTime, 0));
                    break;
            }
        }
    }
}
