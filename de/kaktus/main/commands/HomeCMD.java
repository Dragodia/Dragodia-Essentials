package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomeCMD implements CommandExecutor {

    private final Main plugin;
    public HomeCMD(Main plugin){
        this.plugin = plugin;
    }

    File file = new File("plugins/System", "homes.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)) {
            return true;
        }
        Player p = (Player) s;

            if (args.length == 1) {

                try {
                    cfg.load(file);
                } catch (IOException | InvalidConfigurationException e) {
                    e.printStackTrace();
                }

                try {
                    cfg.load(file);
                } catch (IOException | InvalidConfigurationException e) {
                    e.printStackTrace();
                }

                if (cfg.isSet(p.getName() + "." + args[0] + ".world")){
                    String world = cfg.getString(p.getName() + "." + args[0] + ".world");
                    double x = cfg.getDouble( p.getName() + "." + args[0] + ".x");
                    double y = cfg.getDouble(p.getName() + "." + args[0] + ".y");
                    double z = cfg.getDouble(p.getName() + "." + args[0] + ".z");
                    double yaw = cfg.getDouble(p.getName() + "." + args[0] + ".yaw");
                    double pitch = cfg.getDouble(p.getName() + "." + args[0] + ".pitch");

                    assert world != null;
                    Location location = new Location(Bukkit.getWorld(world), x, y, z);
                    location.setPitch((float) pitch);
                    location.setYaw((float) yaw);

                    p.teleport(location);
                    p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
                }else{
                    p.sendMessage(Main.pre + "§7Dieses Home §cexistiert §7nicht!");
                }
            } else {
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/home <Name>");
            }
        return false;
    }
}
