package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class StopCMD implements CommandExecutor {

    int time;
    int countdown;

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player){
            Player p = (Player)s;
            if (p.hasPermission("essentials.stop") || p.hasPermission("essentials.admin")){

                for (Player all : Bukkit.getOnlinePlayers()){
                    all.sendMessage(Main.pre + "§c§lDer Server stoppt in 10 Sekunden!");
                }
                time = 11;
                countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                    @Override
                    public void run() {
                        time --;
                        if (time == 5){
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c5 Sekunden");
                            }
                        }
                        if (time == 4){
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c4 Sekunden");
                            }
                        }
                        if (time == 3) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c3 Sekunden");
                            }
                        }
                        if (time == 2) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c2 Sekunden");
                            }
                        }
                        if (time == 1) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c1 Sekunde");
                            }
                        }
                        if (time == 0){
                            Bukkit.getServer().shutdown();
                            Bukkit.getScheduler().cancelTask(countdown);
                        }
                    }
                }, 20, 20);
            }else{
                p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
            }
        } else if (s instanceof ConsoleCommandSender) {
            ConsoleCommandSender c = (ConsoleCommandSender)s;

                time = 61;
                countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                    @Override
                    public void run() {
                        time --;

                        if (time == 60){
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c§lUPDATE! Neustart in 1 Minute!");
                            }
                        }
                        if (time == 5){
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c5 Sekunden");
                            }
                        }
                        if (time == 4){
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c4 Sekunden");
                            }
                        }
                        if (time == 3) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c3 Sekunden");
                            }
                        }
                        if (time == 2) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c2 Sekunden");
                            }
                        }
                        if (time == 1) {
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Main.pre + "§c1 Sekunde");
                            }
                        }
                        if (time == 0){
                            Bukkit.getServer().shutdown();
                            Bukkit.getScheduler().cancelTask(countdown);
                        }
                    }
                }, 20, 20);
            }
        return false;
    }
}
