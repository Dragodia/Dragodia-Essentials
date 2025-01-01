package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlaceItem {

    public static void items(){
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName("§1");
        itemStack.setItemMeta(itemMeta);

        Main.help.setItem(0, itemStack);
        Main.help.setItem(1, itemStack);
        Main.help.setItem(2, itemStack);
        Main.help.setItem(3, itemStack);
        Main.help.setItem(4, itemStack);
        Main.help.setItem(5, itemStack);
        Main.help.setItem(6, itemStack);
        Main.help.setItem(7, itemStack);
        Main.help.setItem(8, itemStack);
        Main.help.setItem(9, itemStack);
        Main.help.setItem(11, itemStack);
        Main.help.setItem(12, itemStack);
        Main.help.setItem(14, itemStack);
        Main.help.setItem(15, itemStack);
        Main.help.setItem(17, itemStack);
        Main.help.setItem(18, itemStack);
        Main.help.setItem(19, itemStack);
        Main.help.setItem(20, itemStack);
        Main.help.setItem(21, itemStack);
        Main.help.setItem(22, itemStack);
        Main.help.setItem(23, itemStack);
        Main.help.setItem(25, itemStack);
        Main.help.setItem(26, itemStack);
        Main.help.setItem(24, itemStack);


        Main.craftMenu.setItem(2, itemStack);
        Main.craftMenu.setItem(3, itemStack);
        Main.craftMenu.setItem(4, itemStack);
        Main.craftMenu.setItem(5, itemStack);
        Main.craftMenu.setItem(6, itemStack);
        Main.craftMenu.setItem(7, itemStack);
        Main.craftMenu.setItem(8, itemStack);

        Main.commandMenu.setItem(8, itemStack);
        Main.rank.setItem(0, itemStack);
        Main.rank.setItem(1, itemStack);
        Main.rank.setItem(2, itemStack);
        Main.rank.setItem(3, itemStack);
        Main.rank.setItem(5, itemStack);
        Main.rank.setItem(6, itemStack);
        Main.rank.setItem(7, itemStack);
        Main.rank.setItem(8, itemStack);

        Main.bankMenu.setItem(0, itemStack);
        Main.bankMenu.setItem(1, itemStack);
        Main.bankMenu.setItem(2, itemStack);
        Main.bankMenu.setItem(3, itemStack);
        Main.bankMenu.setItem(4, itemStack);
        Main.bankMenu.setItem(5, itemStack);
        Main.bankMenu.setItem(6, itemStack);
        Main.bankMenu.setItem(7, itemStack);
        Main.bankMenu.setItem(8, itemStack);
        Main.bankMenu.setItem(9, itemStack);
        Main.bankMenu.setItem(10, itemStack);
        Main.bankMenu.setItem(12, itemStack);
        Main.bankMenu.setItem(14, itemStack);
        Main.bankMenu.setItem(16, itemStack);
        Main.bankMenu.setItem(17, itemStack);
        Main.bankMenu.setItem(18, itemStack);
        Main.bankMenu.setItem(19, itemStack);
        Main.bankMenu.setItem(20, itemStack);
        Main.bankMenu.setItem(21, itemStack);
        Main.bankMenu.setItem(22, itemStack);
        Main.bankMenu.setItem(24, itemStack);
        Main.bankMenu.setItem(25, itemStack);
        Main.bankMenu.setItem(26, itemStack);
        Main.bankMenu.setItem(27, itemStack);
        Main.bankMenu.setItem(28, itemStack);
        Main.bankMenu.setItem(29, itemStack);
        Main.bankMenu.setItem(30, itemStack);
        Main.bankMenu.setItem(31, itemStack);
        Main.bankMenu.setItem(32, itemStack);
        Main.bankMenu.setItem(33, itemStack);
        Main.bankMenu.setItem(34, itemStack);
        Main.bankMenu.setItem(35, itemStack);
    }
}
