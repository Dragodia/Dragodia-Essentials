package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.util.RandomTeleport;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RtpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("rtp.cmd")){
            RandomTeleport randomTeleport = new RandomTeleport();
            randomTeleport.teleportPlayer(p);
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
