package de.kaktus.main.commands;

import de.kaktus.main.util.UtilManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class ReportCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        UtilManager utilManager = new UtilManager();
        if (args.length == 2){
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null){
                if (args[1].equalsIgnoreCase("hacking")){
                    utilManager.getConfig("plugins/Reports/reports.yml").set("Player." + p.getName(), args[1]);

                }
            }
        }
        return false;
    }
}
