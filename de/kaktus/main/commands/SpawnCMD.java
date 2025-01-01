package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SpawnCMD implements CommandExecutor {

    File file = new File("plugins/System", "spawn.yml");
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

        String world = cfg.getString(".world");
        double x = cfg.getDouble(".x");
        double y = cfg.getDouble(".y");
        double z = cfg.getDouble(".z");
        double yaw = cfg.getDouble(".yaw");
        double pitch = cfg.getDouble(".pitch");

        assert world != null;
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        location.setPitch((float) pitch);
        location.setYaw((float) yaw);

        p.teleport(location);
        p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
        return false;
    }
}
