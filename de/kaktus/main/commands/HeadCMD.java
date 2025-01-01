package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("essentials.head") || p.hasPermission("essentials.admin")){
            if (args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null){
                    ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
                    assert t != null;
                    skullMeta.setOwner(t.getName());
                    skullMeta.setOwningPlayer(t.getPlayer());
                    itemStack.setItemMeta(skullMeta);

                    p.getInventory().addItem(itemStack);
                    p.sendMessage(Main.pre + "§7Du hast den Kopf von §a" + t.getName() + "§7 erhalten!");
                }else{
                    p.sendMessage(Main.pre + "§7Dieser Spieler ist §cnicht §7online!");
                }
            }else{
                p.sendMessage(Main.pre + "§7Bitte nutze: §c/kopf <Spieler>");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
