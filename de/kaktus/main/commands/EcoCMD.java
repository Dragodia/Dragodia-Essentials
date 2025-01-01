package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class EcoCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        MoneyAPI moneyAPI = new MoneyAPI();
        if (args.length == 3){
            if (p.hasPermission("essentials.eco") || p.hasPermission("essentials.admin")){
                if (args[0].equalsIgnoreCase("give")){
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null){
                        try {
                            int amount = Integer.parseInt(args[2]);
                            moneyAPI.addMoney(t, amount);
                            p.sendMessage(Main.pre + "§a" + t.getName() + "§7 wurden §a" + amount + " Coin(s) §7gegeben!");
                            t.sendMessage(Main.pre + "§7Dir wurden §a" + amount + " Coin(s) §7gegeben!");

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                                }
                            }.runTaskLater(Main.getInstance(), 1);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(t));
                                }
                            }.runTaskLater(Main.getInstance(), 1);

                        } catch (NumberFormatException e) {
                            p.sendMessage(Main.pre + "§7Ungültige §cEingabe§7!");
                            return true;
                        }
                    }else{
                        p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                    }
                } else if (args[0].equalsIgnoreCase("set")) {
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null){
                        try {
                            int amount = Integer.parseInt(args[2]);
                            moneyAPI.setMoney(t, amount);
                            p.sendMessage(Main.pre + "§7Kontostand von §a" + t.getName() + "§7 auf §a" + amount + " Coin(s) §7gesetzt!");

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                                }
                            }.runTaskLater(Main.getInstance(), 1);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(t));
                                }
                            }.runTaskLater(Main.getInstance(), 1);

                        } catch (NumberFormatException e) {
                            p.sendMessage(Main.pre + "§7Ungültige §cEingabe§7!");
                            return true;
                        }
                    }else{
                        p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t != null){
                        try {
                            int amount = Integer.parseInt(args[2]);
                            if (moneyAPI.getMoney(t) >= amount){
                                moneyAPI.removeMoney(t, amount);
                                p.sendMessage(Main.pre + "§a" + t.getName() + "§7 wurden §a" + amount + " Coin(s) §7entfernt!");

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                                    }
                                }.runTaskLater(Main.getInstance(), 1);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(t));
                                    }
                                }.runTaskLater(Main.getInstance(), 1);

                            }else{
                                p.sendMessage(Main.pre + "§7Dieser Spieler hat §cnicht §7genug Guthaben!");
                            }
                        } catch (NumberFormatException e) {
                            p.sendMessage(Main.pre + "§7Ungültige §cEingabe§7!");
                            return true;
                        }
                    }else{
                        p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                    }
                }else{
                    p.sendMessage(Main.pre + "§7Bitte nutze: \n §1 \n §a/eco give <Name> <Zahl> \n §2 \n §a/eco set <Name> <Zahl> \n §3 \n §a/eco remove <Name> <Zahl>");
                }
            }else{
                p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Bitte nutze: \n §1 \n §a/eco give <Name> <Zahl> \n §2 \n §a/eco set <Name> <Zahl> \n §3 \n §a/eco remove <Name> <Zahl>");
        }
        return false;
    }
}
