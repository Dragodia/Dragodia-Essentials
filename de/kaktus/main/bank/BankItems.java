package de.kaktus.main.bank;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BankItems {

    public static void items(){
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
        moneyBigMeta.setDisplayName("§2§l10 Coin");
        moneyBigMeta.setLore(List.of("§7Linksklick zum einzahlen", "§7Rechtsklick zum auszahlen"));
        moneyBig.setItemMeta(moneyBigMeta);

        ItemStack budget = new ItemStack(Material.GOLD_INGOT);
        ItemMeta budgetMeta = budget.getItemMeta();
        assert moneyBigMeta != null;
        moneyBigMeta.setDisplayName("§2§l10 Coin");
        moneyBigMeta.setLore(List.of("§7Linksklick zum einzahlen", "§7Rechtsklick zum auszahlen"));
        budget.setItemMeta(moneyBigMeta);

        Main.bankMenu.setItem(15, moneyBig);
        Main.bankMenu.setItem(13, money);
        Main.bankMenu.setItem(11, safe);


    }
}
