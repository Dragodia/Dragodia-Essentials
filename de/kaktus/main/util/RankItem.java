package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RankItem {

    public static void items(){
        ItemStack prem = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta premMeta = prem.getItemMeta();
        assert premMeta != null;
        premMeta.setDisplayName("§6§lPremium Rang");
        premMeta.setLore(List.of("§7Enthält folgende Vorteile:",
                "§7- §eDu bekommst einen §6§lgoldenen §ePräfix",
                "§7- §5§l/kopf §7- §egibt dir den Kopf eines Spielers",
                "§7- §eKann vollen Server betreten",
                "§7- §5§l/important §7- §eKann herforgehobene Nachrichten schreiben",
                "§7- §eKann §5F§aa§br§eb§ci§0g §eschreiben",
                "§cPreis: 100.000 Coins"));
        prem.setItemMeta(premMeta);
        Main.rank.setItem(4, prem);
    }
}
