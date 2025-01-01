package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveallCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.giveall") || p.hasPermission("essentials.admin")){
            if (!(p.getItemInHand().getType() == Material.AIR)){
                for (Player all : Bukkit.getOnlinePlayers()){
                    all.getInventory().addItem(p.getItemInHand());
                    all.sendMessage(Main.pre + "§7Alle Spieler haben §a" + p.getItemInHand().getType() + "§7 bekommen!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nehme ein §aItem §7in die Hand!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
