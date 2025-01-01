package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;

            if (p.hasPermission("essentials.vanish") || p.hasPermission("essentials.admin")) {
                if (args.length == 0) {
                    if (!Main.vanish.contains(p)) {
                        Main.vanish.add(p);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(p);
                        }
                        p.sendMessage(Main.pre + "§7Du bist nun §aunsichtbar§7!");
                    } else {
                        Main.vanish.remove(p);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                        }
                        p.sendMessage(Main.pre + "§7Du bist nun §asichtbar§7!");
                    }
                } else if (args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t != null){
                        if (!Main.vanish.contains(t)){
                            Main.vanish.add(t);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.hidePlayer(t);
                            }
                            t.sendMessage(Main.pre + "§7Du bist nun §aunsichtbar§7!");
                            p.sendMessage(Main.pre + "§7Der Spieler §a" + t.getName() + "§7 ist nun §aunsichtbar§7!");
                        }else{
                            Main.vanish.remove(t);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(t);
                            }
                            t.sendMessage(Main.pre + "§7Du bist nun §asichtbar§7!");
                            p.sendMessage(Main.pre + "§7Der Spieler §a" + t.getName() + "§7 ist nun §asichtbar§7!");
                        }
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
