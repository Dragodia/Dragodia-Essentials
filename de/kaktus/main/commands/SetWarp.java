package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetWarp implements CommandExecutor {

    File file = new File("plugins/System", "warps.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    File names = new File("plugins/System", "warp_names.yml");
    FileConfiguration nameCfg = YamlConfiguration.loadConfiguration(names);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.setwarp") || p.hasPermission("essentials.admin")) {

            if (args.length == 1){

                if (!cfg.isSet(args[0] + ".world")){
                    String world = p.getWorld().getName();
                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    double yaw = p.getLocation().getYaw();
                    double pitch = p.getLocation().getPitch();

                    cfg.set(args[0] + ".world", world);
                    cfg.set(args[0] + ".x", x);
                    cfg.set(args[0] + ".y", y);
                    cfg.set(args[0] + ".z", z);
                    cfg.set(args[0] + ".yaw", yaw);
                    cfg.set(args[0] + ".pitch", pitch);

                    nameCfg.set(args[0], "");

                    try {
                        cfg.save(file);
                        nameCfg.save(names);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    p.sendMessage(Main.pre + "§7Du hast den Warp §a[" + args[0] + "] §7gesetzt!");
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
                }else{
                    p.sendMessage(Main.pre + "§7Warp existiert §cbereits§7!");
                }

            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/setwarp <Name>");
            }

        }
        return false;
    }
}
