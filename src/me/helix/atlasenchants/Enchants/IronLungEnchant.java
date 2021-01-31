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
    public void onRightClickAir(PlayerInteractEvent e) {
    	if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
    		if(e.getPlayer().getItemInHand().getItemMeta().getLore() == IronLungEnchant.lore) {
            	if(hasCustomEnchant(e.getPlayer().getInventory().getHelmet()) == true) {
            		ItemStack helmet = e.getPlayer().getInventory().getHelmet();
            		ItemMeta HelmetMeta = helmet.getItemMeta();
                    lore.add(Main.color("&cIronLung I"));
                    HelmetMeta.setLore(lore);
                    helmet.setItemMeta(HelmetMeta);
                	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
            	}else {
                	if(e.getPlayer().getActivePotionEffects() != null) {
                    	e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
                	}
                }
    		}
    	}
    }
    @EventHandler
    public void onInvChange(InventoryClickEvent e) {
        if(isHelmet(e.getWhoClicked().getInventory().getHelmet().getType()) == true) {
        	if(hasCustomEnchant(e.getWhoClicked().getInventory().getHelmet()) == true) {
        		ItemStack helmet = e.getWhoClicked().getInventory().getHelmet();
        		ItemMeta HelmetMeta = helmet.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Main.color("&cIronLung I"));
                HelmetMeta.setLore(lore);
                helmet.setItemMeta(HelmetMeta);
            	e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
        	}
        }else {
        	if(e.getWhoClicked().getActivePotionEffects() != null) {
            	e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
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
