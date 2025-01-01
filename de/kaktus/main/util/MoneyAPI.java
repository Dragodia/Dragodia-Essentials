package de.kaktus.main.util;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class MoneyAPI {

    private UtilManager fileManager = new UtilManager();

    public Integer getMoney(OfflinePlayer player) {
        YamlConfiguration configuration = this.fileManager.getConfig("plugins/System/money.yml");
        int money = 0;
        if (configuration.getString("Player." + player.getUniqueId()) != null)
            money = configuration.getInt("Player." + player.getUniqueId());
        return Integer.valueOf(money);
    }

    public void setMoney(OfflinePlayer player, int amount) {
        YamlConfiguration configuration = this.fileManager.getConfig("plugins/System/money.yml");
        configuration.set("Player." + player.getUniqueId(), Integer.valueOf(amount));
        this.fileManager.save(new File("plugins/System/money.yml"), configuration);
    }

    public void addMoney(OfflinePlayer player, int amount) {
        YamlConfiguration configuration = this.fileManager.getConfig("plugins/System/money.yml");
        setMoney(player, getMoney(player).intValue() + amount);
    }

    public void removeMoney(OfflinePlayer player, int amount) {
        YamlConfiguration configuration = this.fileManager.getConfig("plugins/System/money.yml");
        if (getMoney(player).intValue() - amount >= 0) {
            setMoney(player, getMoney(player).intValue() - amount);
        } else {
            setMoney(player, 0);
        }
    }
}
