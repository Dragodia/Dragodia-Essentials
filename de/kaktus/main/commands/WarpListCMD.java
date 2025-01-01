package de.kaktus.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.Scanner;

public class WarpListCMD implements CommandExecutor {

    File names = new File("plugins/System", "warp_names.yml");
    FileConfiguration nameCfg = YamlConfiguration.loadConfiguration(names);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;

        try {
            Scanner scanner = new Scanner(new File("warp_names.yml"));
            p.sendMessage(scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
