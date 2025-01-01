package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.scoreboard.CustomScoreboard;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class Join implements Listener {

    File file = new File("plugins/System", "spawn.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        MoneyAPI moneyAPI = new MoneyAPI();
        e.setJoinMessage(null);

        p.setScoreboard(CustomScoreboard.setScoreboard(p));

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()){
                    Objects.requireNonNull(all.getScoreboard().getTeam("players")).setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());
                }
            }
        }.runTaskLater(Main.getInstance(), 1);

        if (!p.hasPlayedBefore()){
            moneyAPI.addMoney(p, 500);
            p.sendMessage(Main.pre + "§7Du hast §a500 Coins §7zum Start erhalten!");
        }

        if (!p.hasPlayedBefore()){
            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemStack pants = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

            ItemStack sword = new ItemStack(Material.STONE_SWORD);
            ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
            ItemStack food = new ItemStack(Material.COOKED_BEEF, 16);
            ItemStack wood = new ItemStack(Material.OAK_PLANKS, 32);

            p.getInventory().addItem(helmet);
            p.getInventory().addItem(chest);
            p.getInventory().addItem(pants);
            p.getInventory().addItem(boots);
            p.getInventory().addItem(sword);
            p.getInventory().addItem(pickaxe);
            p.getInventory().addItem(food);
            p.getInventory().addItem(wood);
        }
    }

    @EventHandler
    public void joinFile(PlayerJoinEvent e){
        Player p = e.getPlayer();

        UUID uuid = p.getUniqueId();
        Location location = p.getLocation();
        String ipAddress = p.getAddress().getAddress().getHostAddress();
        String name = p.getName();

        File file = new File("plugins/System/players/", uuid + ".yml");
        try {
            if (!file.exists()){
                boolean newFile = file.createNewFile();
                if (newFile){
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write("Player UUID: " + uuid + "\n");
                    fileWriter.write("Player Join Location: " + location.getWorld().getName() + ", "
                            + location.getX() + ", " + location.getY() + ", " + location.getZ() + "\n");
                    fileWriter.write("Player IP Address: " + ipAddress + "\n");
                    fileWriter.write("Player Name: " + name);
                    fileWriter.close();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    @EventHandler
    public void TPSpawn(PlayerJoinEvent e){
        Player p = e.getPlayer();

        try {
            cfg.load(file);
        } catch (IOException | InvalidConfigurationException ex) {
            ex.printStackTrace();
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
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()){
                    Objects.requireNonNull(all.getScoreboard().getTeam("players")).setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());
                }
            }
        }.runTaskLater(Main.getInstance(), 1);

        e.setQuitMessage(null);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();

        if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL){
            if (p.hasPermission("essentials.fulljoin") || p.hasPermission("essentials.admin")){
                e.allow();
            }
        }
    }
}
