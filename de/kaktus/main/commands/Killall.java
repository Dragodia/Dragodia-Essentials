package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class Killall implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.killall") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("players")){
                    for (Player all : Bukkit.getOnlinePlayers()){
                        all.setHealth(0);
                    }
                    p.sendMessage(Main.pre + "§7Alle Entities wurden §centfernt§7!");
                } else if (args[0].equalsIgnoreCase("mobs")) {
                    Entity entity = (Entity) p.getWorld().getEntities();
                    if (entity instanceof Mob){
                        entity.remove();
                        p.sendMessage(Main.pre + "§7Alle Entities wurden §centfernt§7!");
                    }
                } else if (args[0].equalsIgnoreCase("entities")) {
                    Entity entity = (Entity) p.getWorld().getEntities();
                    if (entity instanceof Item){
                        entity.remove();
                        p.sendMessage(Main.pre + "§7Alle Entities wurden §centfernt§7!");
                    }
                } else if (args[0].equalsIgnoreCase("monsters")) {
                    Entity entity = (Entity) p.getWorld().getEntities();
                    if (entity instanceof Monster){
                        entity.remove();
                        p.sendMessage(Main.pre + "§7Alle Entities wurden §centfernt§7!");
                    }
                } else if (args[0].equalsIgnoreCase("animals")) {
                    Entity entity = (Entity) p.getWorld().getEntities();
                    if (entity instanceof Animals){
                        entity.remove();
                        p.sendMessage(Main.pre + "§7Alle Entities wurden §centfernt§7!");
                    }
                }else{
                    p.sendMessage(Main.pre + "§7Bitte nutze: §c/killall <animals/monsters/mobs/entities/players>");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: /killall <entity>");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
