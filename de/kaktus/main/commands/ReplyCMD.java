package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.kaktus.main.commands.MsgCMD.getReplay;

public class ReplyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)) {
            return true;
        }
        Player p = (Player)s;
        if (args.length >= 1) {
            Player t = Bukkit.getPlayer(MsgCMD.getReplay().get(p.getUniqueId()));
            if (t != null){
                    String msg = "";
                    for (int i = 0; i<args.length; i++){
                        msg = msg + args[i] + " ";
                    }
                    p.sendMessage("§8[§cmir §7-> §c" + t.getName() + "§8] §7" + msg.replaceAll("&", "§"));
                    t.sendMessage("§8[§c" + p.getName() + " §7-> §c mir§8] §7" + msg.replaceAll("&", "§"));
                    MsgCMD.getReplay().put(p.getUniqueId(), t.getUniqueId());
                    MsgCMD.getReplay().put(t.getUniqueId(), p.getUniqueId());
            }else{
                p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Bitte nutze: §c/r <Nachricht>");
        }
        return false;
    }
}
