package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Inv implements Listener {

    File file = new File("plugins/System", "backpack.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void onInt(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.hasItem()){
            if (e.getItem().hasItemMeta()){
                if (e.getItem().getItemMeta().getDisplayName().equals("§5Rucksack")){
                    if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                        p.openInventory(p.getEnderChest());
                    }
                }
            }
        }
    }

    @EventHandler
    public void Place(BlockPlaceEvent e){
        Player p = e.getPlayer();

        if (e.getItemInHand().getItemMeta().getDisplayName().equals("§5Rucksack")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInv(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        MoneyAPI moneyAPI = new MoneyAPI();

        if (e.getCurrentItem() == null) return;
        if (!e.getCurrentItem().hasItemMeta()) return;

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aCrafting Rezepte")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.openInventory(Main.craftMenu);
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aCommands")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.openInventory(Main.commandMenu);
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSocials")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.openInventory(Main.socials);
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Rucksack§2")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.openInventory(Main.bpCraft);
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aCHEST")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aENDER_EYE")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/farm")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/money")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/pay")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/msg")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/tpa")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/bank")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/tpaccept")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cYouTube")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.sendMessage(Main.pre + "§7YouTube Kanal - §ahttps://www.youtube.com/@DragoBasler");
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bTwitter")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.sendMessage(Main.pre + "§7Twitter - §bhttps://twitter.com/DragoBasler");
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§1FaceBook")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.sendMessage(Main.pre + "§7FaceBook - §1https://www.facebook.com/Dragobaslerofficial/");
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Twitch")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
                p.closeInventory();
            }
            p.sendMessage(Main.pre + "§7Twitch - §5https://www.twitch.tv/dragobasler");
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Discord")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.sendMessage(Main.pre + "§7Discord - §9https://discord.gg/uBatjWnY93");
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§1")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (p.getOpenInventory().getTitle().equals("§2§lRang Menü")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lPremium Rang")){
            if (moneyAPI.getMoney(p) >= 100000){
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user [NAME] parent set premium".replace("[NAME]", p.getName()));
                moneyAPI.removeMoney(p, 100000);
                p.closeInventory();
                p.sendMessage(Main.pre + "§7Du besitzt nun §6§lPremium§7!");
            }else{
                p.sendMessage(Main.pre + "§7Du hast §czu wenig §7Geld!");
                p.closeInventory();
            }
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Mace§2")){
            if (e.isShiftClick() && e.isLeftClick() || e.isShiftClick() && e.isRightClick()){
                e.setCancelled(true);
            }
            p.openInventory(Main.maceCraft);
            e.setCancelled(true);
        }
        if (p.getOpenInventory().getTitle().equals("§aSTICK")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (p.getOpenInventory().getTitle().equals("§aDIAMOND_BLOCK")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a/sethome <Name>")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if (p.getOpenInventory().getTitle().equals("§2§lBackpack")){
            ItemStack[] itemStacks = p.getInventory().getContents();
            cfg.set(p.getUniqueId().toString() , "." + Arrays.toString(itemStacks));
            try {
                cfg.save(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onOpenInv(InventoryOpenEvent e){
        Player p = (Player) e.getPlayer();

        if (p.getOpenInventory().getTitle().equals("§2§lBackpack")){
            ItemStack[] itemStacks = p.getInventory().getContents();
        }
    }
}
