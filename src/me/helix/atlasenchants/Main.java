package me.helix.atlasenchants;

import me.helix.atlasenchants.Commands.BlackSmithCommands;
import me.helix.atlasenchants.Commands.ShopCommand;
import me.helix.atlasenchants.Enchants.FearsightEnchant;
import me.helix.atlasenchants.Events.InvinClickEvent;
import me.helix.atlasenchants.GUIS.BlackSmith;
import me.helix.atlasenchants.GUIS.Godly.GodlyEnchants;
import me.helix.atlasenchants.GUIS.Shop;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main extends JavaPlugin implements Listener {

    public HashMap<Player, Inventory> BlackSmithInventory = new HashMap<Player, Inventory>();
    public HashMap<Player, Inventory> ShopInventory = new HashMap<Player, Inventory>();
    public HashMap<Player, Boolean> hasHelmet = new HashMap<>();
    public HashMap<Player, List<Entity>> playerEntities = new HashMap<>();
    public HashMap<Player, BukkitTask> ColorTask = new HashMap<>();

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }

        Bukkit.getConsoleSender().sendMessage(color("&7============================================="));
        Bukkit.getConsoleSender().sendMessage(color("&l&eAtlas Custom Enchants &7: &a2&7.&a0&e+"));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(color("&eMade by &7: &eChelsea1124&7/&eHELIX & Ghillie"));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(color("&eVersion &7: &a2&7.&a0&e+"));
        Bukkit.getConsoleSender().sendMessage(color("&7============================================="));

        //All Events
        this.getServer().getPluginManager().registerEvents(new BlackSmith(this), this);
        this.getServer().getPluginManager().registerEvents(new BlackSmithCommands(this), this);
        this.getServer().getPluginManager().registerEvents(new FearsightEnchant(this), this);
        this.getServer().getPluginManager().registerEvents(new Shop(this), this);
        this.getServer().getPluginManager().registerEvents(new GodlyEnchants(this),this);
        this.getServer().getPluginManager().registerEvents(new InvinClickEvent(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        //All Commands
        this.getCommand("blacksmith").setExecutor(new BlackSmithCommands(this));
        this.getCommand("shop").setExecutor(new ShopCommand(this));

    }

}
