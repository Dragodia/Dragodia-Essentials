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

public class PayCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        MoneyAPI moneyAPI = new MoneyAPI();
        if (args.length == 2){

            Player t = Bukkit.getPlayer(args[0]);

            if (t != null){
                try {
                    int amount = Integer.parseInt(args[1]);
                    if (moneyAPI.getMoney(p) >= amount){
                        moneyAPI.removeMoney(p, amount);
                        moneyAPI.addMoney(t, amount);
                        p.sendMessage(Main.pre + "§a" + t.getName() + "§7 wurden §a" + amount + " Coin(s) §7gegeben!");
                        t.sendMessage(Main.pre + "§a" + p.getName() + "§7 hat dir §a" + amount + " Coin(s) §7gegeben!");

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
                        p.sendMessage(Main.pre + "§7Du hast §cnicht genug §7Geld!");
                    }
                } catch (NumberFormatException e) {
                    p.sendMessage(Main.pre + "§7Ungültige §cEingabe§7!");
                    return true;
                }
            }else{
                p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
            }
        }else{
            p.sendMessage(Main.pre + "§cBitte nutze: /pay <Name> <Zahl>");
        }
        return false;
    }
}
