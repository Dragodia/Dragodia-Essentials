package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import org.bukkit.entity.Player;

public class Construct {


    public static void openCustomInventory(Player player){
        MoneyAPI moneyAPI = new MoneyAPI();
        BankAPI bankAPI = new BankAPI();


        ItemStack safe = new ItemStack(Material.CHEST);
        ItemMeta safeMeta = safe.getItemMeta();
        assert safeMeta != null;
        safeMeta.setDisplayName("§2§lSchließfach");
        safeMeta.setLore(List.of("§7Klicke um das Schließfach zu öffnen!"));
        safe.setItemMeta(safeMeta);

        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyMeta = money.getItemMeta();
        assert moneyMeta != null;
        moneyMeta.setDisplayName("§2§l1 Coin");
        moneyMeta.setLore(List.of("§7Linksklick zum einzahlen", "§7Rechtsklick zum auszahlen"));
        money.setItemMeta(moneyMeta);

        ItemStack moneyBig = new ItemStack(Material.GOLD_INGOT);
        ItemMeta moneyBigMeta = moneyBig.getItemMeta();
        assert moneyBigMeta != null;
        moneyBigMeta.setDisplayName("§2§l10 Coins");
        moneyBigMeta.setLore(List.of("§7Linksklick zum einzahlen", "§7Rechtsklick zum auszahlen"));
        moneyBig.setItemMeta(moneyBigMeta);

        ItemStack budget = new ItemStack(Material.GOLD_INGOT);
        ItemMeta budgetMeta = budget.getItemMeta();
        assert budgetMeta != null;
        budgetMeta.setDisplayName("§2§lKontostand");
        budgetMeta.setLore(List.of("§2§lKonto §a" + moneyAPI.getMoney(player), "§2§lBank §a" + bankAPI.getMoney(player)));
        budget.setItemMeta(budgetMeta);

        ItemStack allMoney = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta allMoneyMeta = allMoney.getItemMeta();
        assert allMoneyMeta != null;
        allMoneyMeta.setDisplayName("§2§lGesamtes Geld");
        allMoneyMeta.setLore(List.of("§7Linksklick zum einzahlen", "§7Rechtsklick zum auszahlen"));
        allMoney.setItemMeta(allMoneyMeta);

        Main.bankMenu.setItem(23, allMoney);
        Main.bankMenu.setItem(21, budget);
        Main.bankMenu.setItem(15, moneyBig);
        Main.bankMenu.setItem(13, money);
        Main.bankMenu.setItem(11, safe);

        player.openInventory(Main.bankMenu);
    }
}
