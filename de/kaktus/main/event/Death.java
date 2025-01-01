package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.util.ChestManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;

public class Death implements Listener {

    public HashMap<Location, ItemStack[]> DeathChestInventory = new HashMap<>();

    @EventHandler
    public void DeathListener(PlayerDeathEvent e) {
        Player p = e.getEntity();
        ChestManager chestManager = new ChestManager();
        if (p instanceof Player) {
            if (p.getInventory().isEmpty())
                return;

            Location loc = p.getLocation();
            loc.setX(Math.round(loc.getX()));
            loc.setY((Math.round(loc.getY()) + 1L));
            loc.setZ(Math.round(loc.getZ()));
            loc.setYaw(0.0F);
            loc.setPitch(0.0F);
            loc.getBlock().setType(Material.CHEST);
            e.getDrops().clear();
            this.DeathChestInventory.put(loc, p.getInventory().getContents());
            chestManager.getInventory(p);
            chestManager.savecfg();
            p.sendMessage(Main.pre + "§7Dein Inventar ist bei §a" + p.getLocation().getX() + " " + p.getLocation().getY() + " " + p.getLocation().getZ() + "§7!");
        }
    }


    @EventHandler
    public void onClickChest(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST) {
            Chest c = (Chest)e.getClickedBlock().getState();
            if (this.DeathChestInventory.containsKey(e.getClickedBlock().getLocation())) {
                e.setCancelled(true);
                Player p = e.getPlayer();
                p.playSound((Entity)p, Sound.ENTITY_PLAYER_LEVELUP, 20.0F, 25.0F);
                ItemStack[] items = this.DeathChestInventory.get(c.getLocation());
                byte b;
                int i;
                ItemStack[] arrayOfItemStack1;
                for (i = (arrayOfItemStack1 = items).length, b = 0; b < i; ) {
                    ItemStack item = arrayOfItemStack1[b];
                    if (item != null)
                        c.getWorld().dropItemNaturally(c.getLocation(), item);
                    b++;
                }
                e.getClickedBlock().setType(Material.AIR);
                this.DeathChestInventory.remove(c.getLocation());
            }
        }
    }

    @EventHandler
    public void onChestBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.CHEST && this.DeathChestInventory.containsKey(e.getBlock().getLocation())) {
            Chest c = (Chest)e.getBlock().getState();
            ItemStack[] items = this.DeathChestInventory.get(c.getLocation());
            byte b;
            int i;
            ItemStack[] arrayOfItemStack1;
            for (i = (arrayOfItemStack1 = items).length, b = 0; b < i; ) {
                ItemStack item = arrayOfItemStack1[b];
                if (item != null)
                    c.getWorld().dropItemNaturally(c.getLocation(), item);
                b++;
            }
            this.DeathChestInventory.remove(c.getLocation());
        }
    }
}
