package de.kaktus.main;

import de.kaktus.main.bank.BankCMD;
import de.kaktus.main.bank.BankInv;
import de.kaktus.main.bank.BankItems;
import de.kaktus.main.commands.*;
import de.kaktus.main.event.*;
import de.kaktus.main.rank.RankCMD;
import de.kaktus.main.util.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JavaPlugin {

    private static Main instance;
    public static String pre = "§c§lDragodia §8» ";
    public static String bc = "§c§lBROADCAST §8» ";
    public static HashMap<Player, Player> tpa = new HashMap<>();
    public static ArrayList<Player> vanish = new ArrayList<>();
    public static Inventory backpack;
    public static HashMap<Player, ItemStack[]> items = new HashMap<>();
    public static Inventory help;
    public static Inventory craftMenu;
    public static Inventory bpCraft;
    public static Inventory commandMenu;
    public static Inventory socials;
    public static Inventory rank;
    public static Inventory maceCraft;
    public static Inventory bankMenu;

    public static ConfigManager cm;

    private HashMap<UUID, Location> homes;


    @Override
    public void onEnable() {
        instance = this;
        PluginManager();
        cm = new ConfigManager();
        cm. savecfg();
        cm.getConfig();
        backpack = Bukkit.createInventory(null, 9*6, "§2§lBackpack");
        maceCraft = Bukkit.createInventory(null, InventoryType.WORKBENCH, "§5Mace");
        socials = Bukkit.createInventory(null, InventoryType.BREWING, "§2Socials");
        commandMenu = Bukkit.createInventory(null,9,"§2Commands");
        craftMenu = Bukkit.createInventory(null,9,"§2Crafting Rezepte");
        bpCraft = Bukkit.createInventory(null, InventoryType.WORKBENCH, "§5Rucksack");
        help = Bukkit.createInventory(null, 27, "§2Hilfe");
        rank = Bukkit.createInventory(null, 9, "§2§lRang Menü");
        bankMenu = Bukkit.createInventory(null, 9*4, "§2§lBank");
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("giveall").setExecutor(new GiveallCMD());
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("heal").setExecutor(new HealCMD());
        getCommand("rtp").setExecutor(new RtpCMD());
        getCommand("tp").setExecutor(new TpCMD());
        getCommand("tphere").setExecutor(new TphCMD());
        getCommand("tpa").setExecutor(new TpaCMD());
        getCommand("tpaccept").setExecutor(new TpaAcceptCMD());
        getCommand("vanish").setExecutor(new VanishCMD());
        getCommand("msg").setExecutor(new MsgCMD());
        getCommand("r").setExecutor(new ReplyCMD());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("day").setExecutor(new Day());
        getCommand("noon").setExecutor(new Noon());
        getCommand("night").setExecutor(new Night());
        getCommand("midnight").setExecutor(new Midnight());
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD());
        getCommand("farm").setExecutor(new FarmCMD());
        getCommand("invsee").setExecutor(new InvSeeCMD());
        getCommand("eco").setExecutor(new EcoCMD());
        getCommand("money").setExecutor(new MoneyCMD());
        getCommand("pay").setExecutor(new PayCMD());
        getCommand("weather").setExecutor(new Weather());
        getCommand("help").setExecutor(new HelpCMD());
        getCommand("sethome").setExecutor(new setHome(this));
        getCommand("home").setExecutor(new HomeCMD(this));
        getCommand("kopf").setExecutor(new HeadCMD());
        getCommand("killall").setExecutor(new Killall());
        getCommand("rang").setExecutor(new RankCMD());
        getCommand("broadcast").setExecutor(new BroadCast());
        getCommand("important").setExecutor(new ImportantCMD());
        getCommand("sun").setExecutor(new SunCMD());
        getCommand("storm").setExecutor(new StormCMD());
        getCommand("stop").setExecutor(new StopCMD());
        getCommand("bank").setExecutor(new BankCMD());
        getCommand("system").setExecutor(new PluginReload());



        this.homes = new HashMap<>();

        Materials();

        Items.items();
        CmdItem.items();
        PlaceItem.items();
        RankItem.items();

        ItemStack itemStack = new ItemStack(Material.ENDER_CHEST);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName("§5Rucksack");
        itemMeta.setLore(Arrays.asList("§bSeltenes Item"));
        itemMeta.setCustomModelData(12345);
        itemStack.setItemMeta(itemMeta);

        ItemStack mace = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta maceMeta = mace.getItemMeta();
        assert maceMeta != null;
        maceMeta.setDisplayName("§5Mace");
        maceMeta.setLore(List.of("§bSeltenes Item", "§7Effektiv ab 4 Blöcken Höhe"));
        maceMeta.setCustomModelData(12345);
        mace.setItemMeta(maceMeta);

        ShapedRecipe recipe = new ShapedRecipe(itemStack);
        recipe.shape("000", "010", "000");
        recipe.setIngredient('0', Material.ENDER_EYE);
        recipe.setIngredient('1', Material.CHEST);
        getServer().addRecipe(recipe);

        ShapedRecipe maceRecipe = new ShapedRecipe(mace);
        maceRecipe.shape("222", "212", "010");
        maceRecipe.setIngredient('0', Material.AIR);
        maceRecipe.setIngredient('1', Material.STICK);
        maceRecipe.setIngredient('2', Material.DIAMOND_BLOCK);
        getServer().addRecipe(maceRecipe);
    }

    @Override
    public void onDisable() {

    }

    public void Materials(){
        BlockBreak.materials.add(Material.COAL_ORE);
        BlockBreak.materials.add(Material.IRON_ORE);
        BlockBreak.materials.add(Material.GOLD_ORE);
        BlockBreak.materials.add(Material.COPPER_ORE);
        BlockBreak.materials.add(Material.LAPIS_ORE);
        BlockBreak.materials.add(Material.REDSTONE_ORE);
        BlockBreak.materials.add(Material.DIAMOND_ORE);
        BlockBreak.materials.add(Material.EMERALD_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_COAL_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_IRON_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_COPPER_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_GOLD_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_REDSTONE_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_LAPIS_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_DIAMOND_ORE);
        BlockBreak.materials.add(Material.DEEPSLATE_EMERALD_ORE);


    }

    public void PluginManager() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new Inv(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new BankInv(), this);
        pm.registerEvents(new WorldChange(), this);
    }



    public static Main getInstance() {
        return instance;
    }


}
