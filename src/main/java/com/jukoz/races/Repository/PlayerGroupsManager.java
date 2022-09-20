package com.jukoz.races.Repository;

import com.jukoz.races.Console.MessageInterceptorCommandRunner;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerGroupsManager implements Listener {
    public static HashMap<UUID, RacesGroup> playersGroup;
    private static final MessageInterceptorCommandRunner cmdRunner = new MessageInterceptorCommandRunner(Bukkit.getConsoleSender());;
    public static final String GET_PLAYER_GROUP_COMMAND = "manwhois ";
    public static final String GET_PLAYER_WORLD_COMMAND = "manselect ";

    public PlayerGroupsManager() {
        playersGroup = new HashMap<>();
    }

    @EventHandler
    private static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!playersGroup.containsKey(player.getUniqueId())) {
            playersGroup.put(player.getUniqueId(), convertStringToGroup(getPlayerGroupString(player)));
        }
    }

    @EventHandler
    private static void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(playersGroup.containsKey(player.getUniqueId())) {
            playersGroup.remove(player.getUniqueId());
        }
    }

    private static String getPlayerGroupString(Player player) {
        String worldCommand = GET_PLAYER_WORLD_COMMAND + player.getWorld().toString();
        Bukkit.dispatchCommand(cmdRunner, worldCommand);
        cmdRunner.clearMessageLog();

        String command = GET_PLAYER_GROUP_COMMAND + player.getName();
        Bukkit.dispatchCommand(cmdRunner, command);
        String output = cmdRunner.getMessageLog();
        cmdRunner.clearMessageLog();
        output = (output.substring(output.indexOf('\n')+1)).toUpperCase(); // Removing first line, in case a player has same name of a group
        return output;
    }

    public static RacesGroup getGroupFromPlayer(Player player) {
        if(!playersGroup.containsKey(player.getUniqueId())) {
            playersGroup.put(player.getUniqueId(), convertStringToGroup(getPlayerGroupString(player)));
        }
        return playersGroup.get(player.getUniqueId());
    }

    public static RacesGroup convertStringToGroup(String group) {
        for (RacesGroup enumGroup: RacesGroup.values()) {
            if(group.contains((enumGroup.name()))) {
                return enumGroup;
            }
        }
        return RacesGroup.NONE;
    }
}
