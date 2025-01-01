package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTeleport {

    public void teleportPlayer(Player player){
        Random random = new Random();
        double x = random.nextInt(2000) - 1000;
        double z = random.nextInt(2000) - 1000;
        double y = player.getWorld().getHighestBlockYAt((int)x, (int)z);
        Location location = new Location(player.getWorld(), x, y, z);
        player.teleport(location);
        player.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
    }
}
