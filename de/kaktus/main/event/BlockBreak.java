package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BlockBreak implements Listener {


    public static List<Material> materials = new ArrayList<>();

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Block block = e.getBlock();
        Player p = e.getPlayer();
        MoneyAPI moneyAPI = new MoneyAPI();

        if (materials.contains(block.getType())){
            moneyAPI.addMoney(p, 3);

            new BukkitRunnable() {
                @Override
                public void run() {
                    Objects.requireNonNull(p.getScoreboard().getTeam("money")).setPrefix("§8» §7" + moneyAPI.getMoney(p));
                }
            }.runTaskLater(Main.getInstance(), 1);
        }
    }
}
