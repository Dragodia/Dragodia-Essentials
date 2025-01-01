package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.gamemode") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("0")){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                }else if (args[0].equalsIgnoreCase("1")){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                }else if (args[0].equalsIgnoreCase("2")){
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                }else if (args[0].equalsIgnoreCase("3")){
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                }else{
                    p.sendMessage(Main.pre + "§7Bitte nutze: §c/gm 0/1/2/3");
                }
            }else if (args.length == 2){
                Player t = Bukkit.getPlayer(args[1]);
                if (t != null){
                    if (args[0].equalsIgnoreCase("0")){
                        t.setGameMode(GameMode.SURVIVAL);
                        t.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                        p.sendMessage(Main.pre + "§7Du hast den Spielmodus von §a" + t.getName() + "§7 geändert!");
                    }else if (args[0].equalsIgnoreCase("1")){
                        t.setGameMode(GameMode.CREATIVE);
                        t.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                        p.sendMessage(Main.pre + "§7Du hast den Spielmodus von §a" + t.getName() + "§7 geändert!");
                    }else if (args[0].equalsIgnoreCase("2")){
                        t.setGameMode(GameMode.ADVENTURE);
                        t.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                        p.sendMessage(Main.pre + "§7Du hast den Spielmodus von §a" + t.getName() + "§7 geändert!");
                    }else if (args[0].equalsIgnoreCase("3")){
                        t.setGameMode(GameMode.SPECTATOR);
                        t.sendMessage(Main.pre + "§7Dein Spielmodus wurde §ageändert§7!");
                        p.sendMessage(Main.pre + "§7Du hast den Spielmodus von §a" + t.getName() + "§7 geändert!");
                    }else{
                        p.sendMessage(Main.pre + "§7Bitte nutze: §c/gm 0/1/2/3  <Spieler>");
                    }
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/gm 0/1/2/3");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
