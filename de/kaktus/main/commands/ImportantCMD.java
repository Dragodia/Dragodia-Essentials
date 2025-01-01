package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ImportantCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.important") || p.hasPermission("essentials.admin")){
            if (args.length >= 1){
                String msg = "";
                for (int i = 0; i<args.length; i++){
                    msg = msg + args[i] + " ";
                }
                for (Player all : Bukkit.getOnlinePlayers()){
                    all.sendMessage("§c§l" + p.getName() + " §8» §c§l" + msg.replaceAll("&", "§"));
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/important <Nachricht>");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
