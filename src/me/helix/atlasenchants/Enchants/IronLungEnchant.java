package me.helix.atlasenchants.Enchants;

import me.helix.atlasenchants.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IronLungEnchant implements Listener {

    private Main main;
    public IronLungEnchant (Main main) {
        this.main = main;
    }

    public boolean isHelmet(Material type) {
        if ((type == Material.LEATHER_HELMET) ||
                (type == Material.IRON_HELMET) ||
                (type == Material.CHAINMAIL_HELMET) ||
                (type == Material.GOLDEN_HELMET) ||
                (type == Material.DIAMOND_HELMET) ||
                (type == Material.NETHERITE_HELMET) ||
                (type == Material.TURTLE_HELMET)) {
            return true;
        }
        return false;
    }
    @EventHandler
    public void onEquip(ArmorEquipEvent e) {
    	if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
    		if(isHelmet(e.getNewArmorPiece().getType()) == true) {
    			if(e.getNewArmorPiece().getItemMeta().hasLore()) {
            		if(hasCustomEnchant(e.getPlayer().getInventory().getHelmet()) == true) {
            			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                    }else {
                    	e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
                    }
    			}
    		}

    		
    	}
    }
    public boolean hasCustomEnchant(ItemStack helmet) {
        ItemMeta helmetMeta = helmet.getItemMeta();
        if (helmetMeta.hasLore()) {
            for (String lore: helmetMeta.getLore()) {
                if ((lore.equals(Main.color("&cIronLung I")))) {
                    return true;
                }
            }
        }
        return false;
    }
}
