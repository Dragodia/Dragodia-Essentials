package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class MsgCMD implements CommandExecutor {

    private static HashMap<UUID, UUID> replay = new HashMap<>();

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)) {
            s.sendMessage("musst ein Spieler sein!");
            return false;
        }
        Player p = (Player)s;
        if (args.length >= 2){
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < args.length; i++)
                    stringBuilder.append(args[i]).append(" ");
                p.sendMessage("§8[§cich §7-> §c" + t.getName() + "§8] §7" + stringBuilder.toString());
                t.sendMessage("§8[§c" + p.getName() + " §7-> §c mir§8] §7" + stringBuilder.toString());
                getReplay().put(p.getUniqueId(), t.getUniqueId());
                getReplay().put(t.getUniqueId(), p.getUniqueId());
            }else{
                p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Bitte nutze: §a/msg <Spieler> <Nachricht>");
        }
        return false;
    }

    public static HashMap<UUID, UUID> getReplay() {
        return replay;
    }
}
