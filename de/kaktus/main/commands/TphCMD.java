package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.teleport") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    t.teleport(p.getLocation());
                    t.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
