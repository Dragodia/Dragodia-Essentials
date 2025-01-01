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

public class setHome implements CommandExecutor {

    private final Main plugin;
    public setHome(Main plugin){
        this.plugin = plugin;
    }

    File file = new File("plugins/System", "homes.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;

        if (args.length == 1){

            if (!cfg.isSet(p.getName() + "." + args[0] + ".world")){
                String world = p.getWorld().getName();
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                double yaw = p.getLocation().getYaw();
                double pitch = p.getLocation().getPitch();

                cfg.set(p.getName() + "." + args[0] + ".world", world);
                cfg.set(p.getName() + "." + args[0] + ".x", x);
                cfg.set(p.getName() + "." + args[0] + ".y", y);
                cfg.set(p.getName() + "." + args[0] + ".z", z);
                cfg.set(p.getName() + "." + args[0] + ".yaw", yaw);
                cfg.set(p.getName() + "." + args[0] + ".pitch", pitch);
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(Main.pre + "§7Dein §aHome [" + args[0] + "] §7wurde erfolgreich gesetzt!");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
            }else{
                p.sendMessage(Main.pre + "§7Dieses Home §cexistiert §7bereits!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Bitte nutze: §c/sethome <Name>");
        }
        return true;
    }
}
