package me.helix.atlasenchants.GUIS.Godly;

import me.helix.atlasenchants.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GodlyEnchants implements Listener {

    private Main main;
    public GodlyEnchants (Main main) { this.main = main;}

    public Inventory GodlyGUI;
    public void build (Player p) {
        GodlyGUI = Bukkit.createInventory(null, InventoryType.CHEST, Main.color(main.getConfig().getString("Shop.GodlyEnchantsList.GodlyEnchantsName")));

        ItemStack FearSight = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta FearSightMeta = FearSight.getItemMeta();
        FearSightMeta.setDisplayName(Main.color(main.getConfig().getString("Shop.GodlyEnchantsList.FearSightName")));
        List<String> FearSightLore = new ArrayList();
        for (String FearSightLoree : main.getConfig().getStringList("Shop.GodlyEnchantsList.FearSightLore")) {
            FearSightLore.add(Main.color(FearSightLoree));
        }
        FearSightMeta.setLore(FearSightLore);
        FearSight.setItemMeta(FearSightMeta);

        ItemStack test2 = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta test2Meta = test2.getItemMeta();
        test2Meta.setDisplayName(Main.color(main.getConfig().getString("Shop.GodlyEnchantsList.testName")));
        List<String> TesttLore = new ArrayList();
        for (String TestLoree : main.getConfig().getStringList("Shop.GodlyEnchantsList.FearSightLore")) {
            TesttLore.add(Main.color(TestLoree));
        }
        test2Meta.setLore(TesttLore);
        test2.setItemMeta(test2Meta);

        ItemStack Filler1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta FillerMeta = Filler1.getItemMeta();
        FillerMeta.setDisplayName(Main.color("&c&lF&6&lU&e&lC&2&lK &b&lO&9&lF&5&lF&f&l!!!"));
        Filler1.setItemMeta(FillerMeta);

        GodlyGUI.setItem(0, Filler1);
        GodlyGUI.setItem(1, Filler1);
        GodlyGUI.setItem(2, Filler1);
        GodlyGUI.setItem(3, Filler1);
        GodlyGUI.setItem(4, Filler1);
        GodlyGUI.setItem(5, Filler1);
        GodlyGUI.setItem(6, Filler1);
        GodlyGUI.setItem(7, Filler1);
        GodlyGUI.setItem(8, Filler1);
        GodlyGUI.setItem(9, Filler1);
        GodlyGUI.setItem(10, FearSight);
        GodlyGUI.setItem(11, Filler1);
        GodlyGUI.setItem(12, test2);
        GodlyGUI.setItem(13, Filler1);
        GodlyGUI.setItem(14, test2);
        GodlyGUI.setItem(15, Filler1);
        GodlyGUI.setItem(16, test2);
        GodlyGUI.setItem(17, Filler1);
        GodlyGUI.setItem(18, Filler1);
        GodlyGUI.setItem(19, Filler1);
        GodlyGUI.setItem(20, Filler1);
        GodlyGUI.setItem(21, Filler1);
        GodlyGUI.setItem(22, Filler1);
        GodlyGUI.setItem(23, Filler1);
        GodlyGUI.setItem(24, Filler1);
        GodlyGUI.setItem(25, Filler1);
        GodlyGUI.setItem(26, Filler1);
    }

    public void show(Player p) {
        Main.instance.ShopInventory.put(p, GodlyGUI);
        p.openInventory(GodlyGUI);
    }
}
