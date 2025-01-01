package de.kaktus.main.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class BackpackManager {

    File file = new File("plugins/System", "backpack.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}
