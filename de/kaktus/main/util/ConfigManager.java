package de.kaktus.main.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    public File file = new File("plugins/System", "spawn_distance.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public void getConfig(){
        if (cfg.getString("Spawn Distance") == null){
            cfg.set("Spawn Distance", Strings.distance);
        }else{
            Strings.distance = cfg.getInt("Spawn Distance");
        }
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
