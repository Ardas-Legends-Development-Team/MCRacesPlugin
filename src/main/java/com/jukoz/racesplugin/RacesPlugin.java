package com.jukoz.racesplugin;

import com.jukoz.racesplugin.EventListeners.*;
import com.jukoz.racesplugin.LoopTasks.PassiveEffects;
import com.jukoz.racesplugin.Repository.PlayerGroupsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RacesPlugin extends JavaPlugin implements Listener {
    PassiveEffects passiveEffects;
    PlayerGroupsManager playerGroupsManager;

    @Override
    public void onEnable() {
        getLogger().info("Initializing RacesPlugin Plugin");

        playerGroupsManager = new PlayerGroupsManager();

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new EntityShootBowEvent(), this);
        getServer().getPluginManager().registerEvents(new OnClick(), this);
        getServer().getPluginManager().registerEvents(new OnEat(), this);
        getServer().getPluginManager().registerEvents(new OnShoot(), this);
        getServer().getPluginManager().registerEvents(new OnKill(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerAttack(), this);
        getServer().getPluginManager().registerEvents(new OnTakeDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerGroupsManager(), this);

        passiveEffects = new PassiveEffects();
        effectUpdate();

        getLogger().info("Finished initializing RacesPlugin Plugin");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling RacesPlugin Plugin");
    }

    public void effectUpdate() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                passiveEffects.applyEffectsToAllPlayers();
            }
        }, 0L, 40L);
    }
}
