package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.util.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class PluginReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.reload") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("reload")){
                    ConfigManager configManager = new ConfigManager();
                    try {
                        configManager.cfg.load(configManager.file);
                    } catch (IOException | InvalidConfigurationException e) {
                        e.printStackTrace();
                    }
                    Main.getInstance().reloadConfig();
                    p.sendMessage(Main.pre + "§7Plugin neu §ageladen§7!");
                }else{
                    p.sendMessage(Main.pre + "§7Bitte nutze: §c/system reload");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/system reload");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
