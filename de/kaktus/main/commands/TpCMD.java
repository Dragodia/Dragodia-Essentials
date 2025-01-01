package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.teleport") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    p.teleport(t.getLocation());
                    p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            } else if (args.length == 3) {
                try {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    int z = Integer.parseInt(args[2]);
                    Location location = new Location(p.getWorld(), x, y, z);
                    p.teleport(location);
                    p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
                } catch (NumberFormatException e){
                    p.sendMessage(Main.pre + "§7Deine Eingabe ist §cungültig§7!");
                    return true;
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/tp <location/Spieler>");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
