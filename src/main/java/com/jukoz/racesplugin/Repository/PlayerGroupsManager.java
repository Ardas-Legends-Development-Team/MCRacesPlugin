package com.jukoz.racesplugin.Repository;

import com.jukoz.racesplugin.Console.MessageInterceptorCommandRunner;
import com.jukoz.racesplugin.Race;
import com.jukoz.racesplugin.Races.AvailableRacesEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerGroupsManager implements Listener {
    public static HashMap<UUID, AvailableRacesEnum> playersGroup;
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
            playersGroup.put(player.getUniqueId(), convertStringToRaceEnum(getPlayerGroupString(player)));
        }
    }

    @EventHandler
    private static void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        playersGroup.remove(player.getUniqueId());
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

    public static AvailableRacesEnum getRaceEnumFromPlayer(Player player) {
        if(!playersGroup.containsKey(player.getUniqueId())) {
            playersGroup.put(player.getUniqueId(), convertStringToRaceEnum(getPlayerGroupString(player)));
        }
        return playersGroup.get(player.getUniqueId());
    }

    public static Race getPlayerRace(UUID uuid) throws ClassNotFoundException {
        if(playersGroup.containsKey(uuid)){
            AvailableRacesEnum raceName=playersGroup.get(uuid);
            return AvailableRacesEnum.getRace(raceName);
        }
        return null;
    }

    public static AvailableRacesEnum convertStringToRaceEnum(String group) {
        for (AvailableRacesEnum enumGroup: AvailableRacesEnum.values()) {
            if(group.contains((enumGroup.name()))) {
                return enumGroup;
            }
        }
        return AvailableRacesEnum.NONE;
    }


}
