package de.kaktus.main.scoreboard;

import de.kaktus.main.event.Chat;
import de.kaktus.main.util.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CustomScoreboard {


    public static Scoreboard setScoreboard(Player player){
        MoneyAPI moneyAPI = new MoneyAPI();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("sb", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§c§lDragodia");
        objective.getScore("§0").setScore(11);
        objective.getScore("§cDein Server").setScore(10);
        objective.getScore("§8» §7CityBuild-1").setScore(9);
        objective.getScore("§1").setScore(8);
        objective.getScore("§cDein Konto").setScore(7);
        objective.getScore("§2").setScore(5);
        objective.getScore("§cSpieler").setScore(4);
        objective.getScore("§3").setScore(2);
        objective.getScore("§c§lDragodia.de").setScore(1);

        Team money = objective.getScoreboard().registerNewTeam("money");
        money.addEntry(ChatColor.BLUE + "" + ChatColor.RED);
        objective.getScore(ChatColor.BLUE + "" + ChatColor.RED).setScore(6);
        money.setPrefix("§8» §7" + moneyAPI.getMoney(player));

        Team players = objective.getScoreboard().registerNewTeam("players");
        players.addEntry(ChatColor.GRAY + "" + ChatColor.BLUE);
        objective.getScore(ChatColor.GRAY + "" + ChatColor.BLUE).setScore(3);
        players.setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());

        return scoreboard;
    }
}
