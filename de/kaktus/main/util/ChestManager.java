package de.kaktus.main.util;

import de.kaktus.main.event.Death;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Arrays;

public class ChestManager {

    File file = new File("plugins/System/chests", "inventory.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public void getInventory(Player player){
        Death death = new Death();
        cfg.getString("Player." + player.getUniqueId(), Arrays.toString(death.DeathChestInventory.get(player)));
        savecfg();
    }

    public void savecfg(){
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
