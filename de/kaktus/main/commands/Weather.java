package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (args.length == 1){
            if (p.hasPermission("essentials.weather") || p.hasPermission("essentials.admin")){
                if (args[0].equalsIgnoreCase("sun")){
                    p.getWorld().setStorm(false);
                    p.sendMessage(Main.pre + "§7Wetter auf §aKlar §7gesetzt!");
                } else if (args[0].equalsIgnoreCase("storm")) {
                    p.getWorld().setStorm(true);
                    p.sendMessage(Main.pre + "§7Wetter auf §aRegen §7gesetzt!");
                }else{
                    p.sendMessage(Main.pre + "§7Bitte nutze: /weather sun/storm");
                }
            }else{
                p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
            }
        }else{
            p.sendMessage(Main.pre + "§cBitte nutze: /weather sun/storm");
        }
        return false;
    }
}
