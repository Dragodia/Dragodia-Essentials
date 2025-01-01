package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class ClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.chat") || p.hasPermission("essentials.admin")){
            for (int i = 0; i < 105; i++){
                Iterator<Player> var7 = (Iterator<Player>) Bukkit.getOnlinePlayers().iterator();
                while (var7.hasNext()){
                    Player all = var7.next();
                    if (!all.hasPermission("essentials.chat") || !all.hasPermission("essentials.admin")){
                        all.chat("");
                    }
                }
            }
            Bukkit.broadcastMessage(Main.pre + "§7Der Chat wurde von §a" + p.getName() + "§7 geleert!");
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
