package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaAcceptCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (Main.tpa.containsKey(p)){
            Player t = (Player) Main.tpa.get(p);
            t.teleport(p.getLocation());
            Main.tpa.remove(t);
            Main.tpa.remove(p);
            t.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
        }else{
            p.sendMessage(Main.pre + "§7Du hast §ckeine §7TPA-Anfrage erhalten!");
        }
        return false;
    }
}
