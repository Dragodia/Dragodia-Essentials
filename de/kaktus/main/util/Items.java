package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Items {

    public static void items(){
        ItemStack itemStack = new ItemStack(Material.ENDER_CHEST);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName("§5Rucksack§2");
        itemMeta.setCustomModelData(12345);
        itemStack.setItemMeta(itemMeta);

        ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta craftMeta = craft.getItemMeta();
        assert craftMeta != null;
        craftMeta.setDisplayName("§aCrafting Rezepte");
        craft.setItemMeta(craftMeta);

        ItemStack cmd = new ItemStack(Material.ACACIA_SIGN);
        ItemMeta cmdMeta = cmd.getItemMeta();
        assert cmdMeta != null;
        cmdMeta.setDisplayName("§aCommands");
        cmd.setItemMeta(cmdMeta);

        ItemStack social = new ItemStack(Material.REDSTONE);
        ItemMeta socialMeta = social.getItemMeta();
        assert socialMeta != null;
        socialMeta.setDisplayName("§aSocials");
        social.setItemMeta(socialMeta);

        ItemStack ender = new ItemStack(Material.ENDER_EYE);
        ItemMeta enderMeta = ender.getItemMeta();
        assert enderMeta != null;
        enderMeta.setDisplayName("§aENDER_EYE");
        ender.setItemMeta(enderMeta);

        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chestMeta = chest.getItemMeta();
        assert chestMeta != null;
        chestMeta.setDisplayName("§aCHEST");
        chest.setItemMeta(chestMeta);

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickMeta = stick.getItemMeta();
        assert stickMeta != null;
        stickMeta.setDisplayName("§aSTICK");
        stick.setItemMeta(stickMeta);

        ItemStack diamondBlock = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta diamondBlockMeta = diamondBlock.getItemMeta();
        assert diamondBlockMeta != null;
        diamondBlockMeta.setDisplayName("§aDIAMOND_BLOCK");
        diamondBlock.setItemMeta(diamondBlockMeta);

        ItemStack mace = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta maceMeta = mace.getItemMeta();
        assert maceMeta != null;
        maceMeta.setDisplayName("§5Mace§2");
        maceMeta.setLore(List.of("§bSeltenes Item", "§7Effektiv ab 4 Blöcken Höhe"));
        maceMeta.setCustomModelData(12345);
        mace.setItemMeta(maceMeta);

        Main.maceCraft.setItem(8, stick);
        Main.maceCraft.setItem(5, stick);
        Main.maceCraft.setItem(6, diamondBlock);
        Main.maceCraft.setItem(4, diamondBlock);
        Main.maceCraft.setItem(3, diamondBlock);
        Main.maceCraft.setItem(2, diamondBlock);
        Main.maceCraft.setItem(1, diamondBlock);
        Main.maceCraft.setItem(0, mace);
        Main.craftMenu.setItem(1, mace);
        Main.bpCraft.setItem(9, ender);
        Main.bpCraft.setItem(8, ender);
        Main.bpCraft.setItem(7, ender);
        Main.bpCraft.setItem(4, ender);
        Main.bpCraft.setItem(6, ender);
        Main.bpCraft.setItem(5, chest);
        Main.bpCraft.setItem(3, ender);
        Main.bpCraft.setItem(2, ender);
        Main.bpCraft.setItem(1, ender);
        Main.bpCraft.setItem(1, ender);
        Main.bpCraft.setItem(0, itemStack);
        Main.craftMenu.setItem(0, itemStack);
        Main.help.setItem(16, social);
        Main.help.setItem(13, cmd);
        Main.help.setItem(10, craft);
    }
}
