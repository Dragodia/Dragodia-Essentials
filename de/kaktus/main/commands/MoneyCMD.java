package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        MoneyAPI moneyAPI = new MoneyAPI();
        if (args.length == 0){
            p.sendMessage(Main.pre + "§7Du hast §a" + moneyAPI.getMoney(p) + " Coin(s)§7!");
        }else if (args.length == 1){
            if (p.hasPermission("essentials.money.other") || p.hasPermission("essentials.admin")){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    p.sendMessage(Main.pre + "§7Der Spieler §a" + t.getName() + "§7 besitzt §a" + moneyAPI.getMoney(t) + " Coin(s)§7!");
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
            }
        }
        return false;
    }
}
