package de.kaktus.main.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String msg = e.getMessage();

        if (p.hasPermission("rank.owner") || p.hasPermission("rank.owner") && p.isOp()){
            e.setFormat("§4Owner §8| §4" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        }else if (p.hasPermission("rank.admin") || p.hasPermission("rank.admin") && p.isOp()){
            e.setFormat("§4Admin §8| §4" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        }else if (p.hasPermission("rank.tech") || p.hasPermission("rank.tech") && p.isOp()){
            e.setFormat("§bDev §8| §b" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        } else if (p.hasPermission("rank.mod") || p.hasPermission("rank.mod") && p.isOp()) {
            e.setFormat("§5Mod §8| §5" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        }else if (p.hasPermission("rank.streamer") || p.hasPermission("rank.streamer") && p.isOp()){
            e.setFormat("§3Streamer §8| §3" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        }else if (p.hasPermission("rank.premium") || p.hasPermission("rank.premium") && p.isOp()){
            e.setFormat("§6Premium §8| §6" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        } else{
            e.setFormat("§7Spieler §8| §7" + p.getName() + " §8» §7" + msg.replaceAll("&", "§"));
        }


        if (p.hasPermission("essentials.chat.color")){
            msg.replaceAll("&", "§");
        }
    }
}
