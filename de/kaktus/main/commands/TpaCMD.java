package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (args.length == 1){
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null){
                Main.tpa.put(t, p);
                p.sendMessage(Main.pre + "§7Du hast eine §aAnfrage §7an §a" + t.getName() + "§7 versendet!");
                t.sendMessage(Main.pre + "§7Der Spieler §a" + p.getName() + "§7 möchte sich zu dir teleportieren! §8[§a/tpaccept§8]");
            }else{
                p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Bitte nutze: §c/tpa <Spieler>");
        }
        return false;
    }
}
