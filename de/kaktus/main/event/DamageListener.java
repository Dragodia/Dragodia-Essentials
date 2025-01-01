package de.kaktus.main.event;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashSet;
import java.util.Set;

public class DamageListener implements Listener {


    private final Set<Player> successfulHits = new HashSet<>();

    @EventHandler
    public void onEntity(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();

            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Mace")){
                double fallDistance = p.getFallDistance();
                double baseDamage = 7.0D;
                double criticalDamage = 1.5D;
                if (fallDistance >= 1.9D){
                    double newDamage = (baseDamage + 3.0D * fallDistance - 5.6D) * criticalDamage + 8.4D;
                    e.setDamage(newDamage);
                    successfulHits.add(p);
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> successfulHits.remove(p), 15L);
                } else if (fallDistance < 1.9D) {
                    e.setDamage(baseDamage);
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if (successfulHits.contains(p)){
                e.setCancelled(true);
                successfulHits.remove(p);
            }
        }
    }
}
