package me.helix.atlasenchants.GUIS;

import me.helix.atlasenchants.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlackSmith implements Listener {

        private Main main;
        public BlackSmith (Main main) {
        this.main = main;
    }

        public Inventory BlackSmithGUI;
        public void build (Player p) {
            BlackSmithGUI = Bukkit.createInventory(null, InventoryType.CHEST, Main.color(main.getConfig().getString(Main.color("BlackSmith.InventoryName"))));

            ItemStack vetro = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta vetroMeta = vetro.getItemMeta();
            vetroMeta.setDisplayName(" ");
            vetro.setItemMeta(vetroMeta);

            ItemStack vetroslot1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta vetroslot1Meta = vetroslot1.getItemMeta();
            vetroslot1Meta.setDisplayName(" ");
            vetroslot1.setItemMeta(vetroslot1Meta);

            ItemStack pulsante = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta pulsanteMeta = pulsante.getItemMeta();
            pulsanteMeta.setDisplayName(Main.color("&a&lUpgrade"));
            pulsante.setItemMeta(pulsanteMeta);

            BlackSmithGUI.setItem(0, vetro);
            BlackSmithGUI.setItem(1, vetro);
            BlackSmithGUI.setItem(2, vetroslot1);
            BlackSmithGUI.setItem(3, vetro);
            BlackSmithGUI.setItem(4, vetro);
            BlackSmithGUI.setItem(5, vetro);
            BlackSmithGUI.setItem(6, vetroslot1);
            BlackSmithGUI.setItem(7, vetro);
            BlackSmithGUI.setItem(8, vetro);
            BlackSmithGUI.setItem(9, vetro);
            BlackSmithGUI.setItem(10, vetroslot1);
            BlackSmithGUI.setItem(12, vetroslot1);
            BlackSmithGUI.setItem(13, vetro);
            BlackSmithGUI.setItem(14, vetroslot1);
            BlackSmithGUI.setItem(16, vetroslot1);
            BlackSmithGUI.setItem(17, vetro);
            BlackSmithGUI.setItem(18, vetro);
            BlackSmithGUI.setItem(19, vetro);
            BlackSmithGUI.setItem(20, vetroslot1);
            BlackSmithGUI.setItem(21, vetro);
            BlackSmithGUI.setItem(22, pulsante);
            BlackSmithGUI.setItem(23, vetro);
            BlackSmithGUI.setItem(24, vetroslot1);
            BlackSmithGUI.setItem(25, vetro);
            BlackSmithGUI.setItem(26, vetro);
    }

    public void show(Player p) {
        Main.instance.BlackSmithInventory.put(p, BlackSmithGUI);
        p.openInventory(BlackSmithGUI);
    }
}
