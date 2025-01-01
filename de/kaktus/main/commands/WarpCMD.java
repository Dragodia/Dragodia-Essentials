package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WarpCMD implements CommandExecutor {

    File file = new File("plugins/System", "warps.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;

        try {
            cfg.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if (cfg.isSet(args[0] + ".world")) {
            String world = cfg.getString(args[0] + ".world");
            double x = cfg.getDouble(args[0] + ".x");
            double y = cfg.getDouble(args[0] + ".y");
            double z = cfg.getDouble(args[0] + ".z");
            double yaw = cfg.getDouble(args[0] + ".yaw");
            double pitch = cfg.getDouble(args[0] + ".pitch");

            assert world != null;
            Location location = new Location(Bukkit.getWorld(world), x, y, z);
            location.setPitch((float) pitch);
            location.setYaw((float) yaw);

            p.teleport(location);
            p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
        }else{
            p.sendMessage(Main.pre + "§7Warp existiert §cnicht§7!");
        }
        return false;
    }
}
