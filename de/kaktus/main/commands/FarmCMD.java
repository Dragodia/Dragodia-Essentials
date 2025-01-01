package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.util.RandomTeleport;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class FarmCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        RandomTeleport randomTeleport = new RandomTeleport();
        p.teleport(Objects.requireNonNull(Bukkit.getWorld("farm")).getSpawnLocation());
        randomTeleport.teleportPlayer(p);
        p.sendMessage(Main.pre + "§7Du wurdest zu §a " + p.getLocation().getX() + " " + p.getLocation().getY() + " " + p.getLocation().getZ() + "§7 teleportiert!");
        return false;
    }
}
