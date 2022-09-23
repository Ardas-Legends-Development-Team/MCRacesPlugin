package com.jukoz.racesplugin.EventListeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnClick implements Listener {

    @EventHandler
    public void InteractEvent(PlayerInteractEvent event) {
        if(event.hasItem()) {
            // If you want to do some actions when user clicks...
        }
    }
}
