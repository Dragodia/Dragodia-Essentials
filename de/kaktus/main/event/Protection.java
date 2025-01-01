package de.kaktus.main.event;

import de.kaktus.main.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.io.File;
import java.util.Objects;

public class Protection implements Listener {

    File file = new File("plugins/System", "spawn.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            int distance = 60;
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
                if (p.getLocation().distance(location) < Strings.distance || p.getLocation().distance(location) == Strings.distance){
                    e.setCancelled(true);
                }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        int distance = 60;
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
            if (p.getLocation().distance(location) < Strings.distance || p.getLocation().distance(location) == Strings.distance){
                e.setCancelled(true);
            }

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        int distance = 60;
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
            if (p.getLocation().distance(location) < Strings.distance || p.getLocation().distance(location) == Strings.distance){
                e.setCancelled(true);
            }

    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e){
        if (e.getEntity() instanceof Creeper){
            Creeper p = (Creeper) e.getEntity();
            int distance = Strings.distance;
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

                if (p.getLocation().distance(location) < Strings.distance || p.getLocation().distance(location) == Strings.distance){
                    e.setCancelled(true);
                }
        }
    }
}
