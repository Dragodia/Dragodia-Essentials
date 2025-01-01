package de.kaktus.main.bank;

import de.kaktus.main.Main;
import de.kaktus.main.util.BankAPI;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class BankInv implements Listener {

    @EventHandler
    public void onInv(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        MoneyAPI moneyAPI = new MoneyAPI();
        BankAPI bankAPI = new BankAPI();

        if (e.getCurrentItem() == null) return;
        if (!e.getCurrentItem().hasItemMeta()) return;

        if (p.getOpenInventory().getTitle().equals("§2§lBank")){
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lSchließfach")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            p.openInventory(p.getEnderChest());
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§l1 Coin")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }

            if (e.isLeftClick()){
                if (moneyAPI.getMoney(p) >= 1){
                    moneyAPI.removeMoney(p, 1);
                    bankAPI.addMoney(p, 1);
                    p.sendMessage(Main.pre + "§7Du hast §a1 Coin §7eingezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld§7!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            if (e.isRightClick()){
                if (bankAPI.getMoney(p) >= 1){
                    bankAPI.removeMoney(p, 1);
                    moneyAPI.addMoney(p, 1);
                    p.sendMessage(Main.pre + "§7Du hast §a1 Coin §7ausgezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld §7auf deiner Bank!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§l10 Coins")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            if (e.isLeftClick()){
                if (moneyAPI.getMoney(p) >= 10){
                    moneyAPI.removeMoney(p, 10);
                    bankAPI.addMoney(p, 10);
                    p.sendMessage(Main.pre + "§7Du hast §a10 Coins §7eingezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld§7!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            if (e.isRightClick()){
                if (bankAPI.getMoney(p) >= 10){
                    bankAPI.removeMoney(p, 10);
                    moneyAPI.addMoney(p, 10);
                    p.sendMessage(Main.pre + "§7Du hast §a10 Coins §7ausgezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld §7auf deiner Bank!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lKontostand")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lGesamtes Geld")){
            if (e.isShiftClick() && e.isRightClick() || e.isShiftClick() && e.isLeftClick()){
                e.setCancelled(true);
            }
            if (e.isLeftClick()){
                if (moneyAPI.getMoney(p) >= 1){
                    bankAPI.addMoney(p, moneyAPI.getMoney(p));
                    moneyAPI.removeMoney(p, bankAPI.getMoney(p));
                    p.sendMessage(Main.pre + "§7Du hast §aalle Coins §7eingezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld§7!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            if (e.isRightClick()){
                if (bankAPI.getMoney(p) >= 1){
                    moneyAPI.addMoney(p, bankAPI.getMoney(p));
                    bankAPI.removeMoney(p, moneyAPI.getMoney(p));
                    p.sendMessage(Main.pre + "§7Du hast §aalle Coins §7ausgezahlt!");
                    e.setCancelled(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                        }
                    }.runTaskLater(Main.getInstance(), 1);
                }else{
                    p.sendMessage(Main.pre + "§7Du hast §czu wenig Geld §7auf deiner Bank!");
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }
    }
}
