package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.invsee") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    p.openInventory(t.getInventory());
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/invsee <Spieler>");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
