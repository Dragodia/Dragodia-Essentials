package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SetSpawnCMD implements CommandExecutor {

    File file = new File("plugins/System", "spawn.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.setspawn") || p.hasPermission("essentials.admin")){
            String world = p.getWorld().getName();
            double x = p.getLocation().getX();
            double y = p.getLocation().getY();
            double z = p.getLocation().getZ();
            double yaw = p.getLocation().getYaw();
            double pitch = p.getLocation().getPitch();

            cfg.set(".world", world);
            cfg.set(".x", x);
            cfg.set(".y", y);
            cfg.set(".z", z);
            cfg.set(".yaw", yaw);
            cfg.set(".pitch", pitch);

            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            p.sendMessage(Main.pre + "§7Du hast den §aSpawn §7gesetzt!");
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
