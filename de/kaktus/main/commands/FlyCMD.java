package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.fly") || p.hasPermission("essentials.admin")){
            if (args.length == 0){
                if (!p.getAllowFlight()){
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(Main.pre + "§7Du kannst nun §afliegen§7!");
                }else{
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(Main.pre + "§7Du kannst nun §cnicht §7mehr fliegen§7!");
                }
            } else if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    if (!t.getAllowFlight()){
                        t.setAllowFlight(true);
                        t.setFlying(true);
                        t.sendMessage(Main.pre + "§7Du kannst nun §afliegen§7!");
                        p.sendMessage(Main.pre + "§7Der Spieler §a" + t.getName() + "§7 kann nun §afliegen§7!");
                    }else{
                        t.setAllowFlight(false);
                        t.setFlying(false);
                        t.sendMessage(Main.pre + "§7Du kannst nun §cnicht §7mehr fliegen§7!");
                        p.sendMessage(Main.pre + "§7Der Spieler §a" + t.getName() + "§7 kann nun §cnicht §7mehr fliegen§7!");
                    }
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/fly");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
