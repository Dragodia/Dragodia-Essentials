package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.heal") || p.hasPermission("essentials.admin")){
            if (args.length == 0){
                p.setHealth(20);
                p.setFoodLevel(20);
                p.sendMessage(Main.pre + "§7Du wurdest §ageheilt§7!");
            }else if (args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    t.setHealth(20);
                    t.setFoodLevel(20);
                    p.sendMessage(Main.pre + "§7Du wurdest §ageheilt§7!");
                    t.sendMessage(Main.pre + "§7Du hast den Spieler §a" + t.getName() + "§7 geheilt!");
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
