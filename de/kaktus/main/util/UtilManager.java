package de.kaktus.main.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class UtilManager {

    public YamlConfiguration getConfig(String pathname) {
        File file = new File(pathname);
        return YamlConfiguration.loadConfiguration(file);
    }

    public File getFile(String pathName) {
        return new File(pathName);
    }

    public void save(File file, YamlConfiguration configuration) {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
