package de.kaktus.main.util;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class CmdItem {

    public static void items(){
        ItemStack rtpCmd = new ItemStack(Material.BOOK);
        ItemMeta rtpCmdMeta = rtpCmd.getItemMeta();
        assert rtpCmdMeta != null;
        rtpCmdMeta.setDisplayName("§a/farm");
        rtpCmdMeta.setLore(Arrays.asList("§7Teleportiert dich in die Farmwelt"));
        rtpCmd.setItemMeta(rtpCmdMeta);

        ItemStack money = new ItemStack(Material.BOOK);
        ItemMeta moneyMeta = money.getItemMeta();
        assert moneyMeta != null;
        moneyMeta.setDisplayName("§a/money");
        moneyMeta.setLore(Arrays.asList("§7Zeigt dir deinen Kontostand"));
        money.setItemMeta(moneyMeta);

        ItemStack pay = new ItemStack(Material.BOOK);
        ItemMeta payMeta = pay.getItemMeta();
        assert payMeta != null;
        payMeta.setDisplayName("§a/pay");
        payMeta.setLore(Arrays.asList("§7Gibt einem Spieler deiner Wahl Geld"));
        pay.setItemMeta(payMeta);

        ItemStack msg = new ItemStack(Material.BOOK);
        ItemMeta msgMeta = msg.getItemMeta();
        assert msgMeta != null;
        msgMeta.setDisplayName("§a/msg");
        msgMeta.setLore(Arrays.asList("§7Schreibe einem Spieler eine private Nachricht"));
        msg.setItemMeta(msgMeta);

        ItemStack tpa = new ItemStack(Material.BOOK);
        ItemMeta tpaMeta = tpa.getItemMeta();
        assert tpaMeta != null;
        tpaMeta.setDisplayName("§a/tpa");
        tpaMeta.setLore(Arrays.asList("§7Teleport-Anfrage an einen Spieler"));
        tpa.setItemMeta(tpaMeta);

        ItemStack tpaccept = new ItemStack(Material.BOOK);
        ItemMeta tpacceptMeta = tpaccept.getItemMeta();
        assert tpacceptMeta != null;
        tpacceptMeta.setDisplayName("§a/tpaccept");
        tpacceptMeta.setLore(Arrays.asList("§7Teleport-Anfrage akzeptieren"));
        tpaccept.setItemMeta(tpacceptMeta);

        ItemStack bank = new ItemStack(Material.BOOK);
        ItemMeta bankMeta = bank.getItemMeta();
        assert bankMeta != null;
        bankMeta.setDisplayName("§a/bank");
        bankMeta.setLore(Arrays.asList("§7Bank Menü öffnen"));
        bank.setItemMeta(bankMeta);

        ItemStack yt = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta ytMeta = yt.getItemMeta();
        assert ytMeta != null;
        ytMeta.setDisplayName("§cYouTube");
        yt.setItemMeta(ytMeta);

        ItemStack twitter = new ItemStack(Material.SPLASH_POTION);
        ItemMeta twitterMeta = twitter.getItemMeta();
        assert twitterMeta != null;
        twitterMeta.setDisplayName("§bTwitter");
        twitter.setItemMeta(twitterMeta);

        ItemStack fb = new ItemStack(Material.POTION);
        ItemMeta fbMeta = fb.getItemMeta();
        assert fbMeta != null;
        fbMeta.setDisplayName("§1FaceBook");
        fb.setItemMeta(fbMeta);

        ItemStack twitch = new ItemStack(Material.POTION);
        ItemMeta twitchMeta = twitch.getItemMeta();
        assert twitchMeta != null;
        twitchMeta.setDisplayName("§5Twitch");
        twitch.setItemMeta(twitchMeta);

        ItemStack discord = new ItemStack(Material.POTION);
        ItemMeta discordMeta = discord.getItemMeta();
        assert discordMeta != null;
        discordMeta.setDisplayName("§9Discord");
        discord.setItemMeta(discordMeta);

        ItemStack home = new ItemStack(Material.BOOK);
        ItemMeta homeMeta = discord.getItemMeta();
        assert homeMeta != null;
        homeMeta.setDisplayName("§a/sethome <Name>");
        homeMeta.setLore(List.of("§7Setze ein Home und teleportiere", "§7dich mit /home <Name> zurück!"));
        home.setItemMeta(homeMeta);

        Main.socials.setItem(3, discord);
        Main.socials.setItem(2, twitch);
        Main.socials.setItem(1, fb);
        Main.socials.setItem(0, twitter);
        Main.socials.setItem(4, yt);

        Main.commandMenu.setItem(7, home);
        Main.commandMenu.setItem(6, bank);
        Main.commandMenu.setItem(5, tpaccept);
        Main.commandMenu.setItem(4, tpa);
        Main.commandMenu.setItem(3, msg);
        Main.commandMenu.setItem(2, pay);
        Main.commandMenu.setItem(1, money);
        Main.commandMenu.setItem(0, rtpCmd);
    }
}
