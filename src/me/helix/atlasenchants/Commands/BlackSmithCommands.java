package me.helix.atlasenchants.Commands;

import me.helix.atlasenchants.GUIS.BlackSmith;
import me.helix.atlasenchants.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class BlackSmithCommands implements CommandExecutor, Listener {

    private Main main;
    public BlackSmithCommands (Main main) {
        this.main = main;
    }

    public int getEmptySlots(Player p) {
        Inventory inventory = p.getInventory();
        ItemStack[] cont = inventory.getContents();
        int i = 0;
        for (ItemStack item : cont) {
            if ((item != null) && (item.getType() != Material.AIR))
                i++;
        }
        return 36 - i;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("ae"))
            if (args.length == 0) {
                if (sender instanceof Player) {
                    Player p = (Player)sender;
                    if (p.getInventory().firstEmpty() != -1) {
                        if (getEmptySlots(p) >= 2) {
                            BlackSmith blackSmithGUI = new BlackSmith(main);
                            blackSmithGUI.build(p);
                            blackSmithGUI.show(p);
                            p.updateInventory();
                        }
                    } else {
                        String fullmessage = main.getConfig().getString("Messages.inventory-full-message-onopen");
                        fullmessage = fullmessage.replaceAll("&", "§");
                                p.sendMessage(fullmessage);
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0F, 1.0F);
                    }
                }
            } else if (sender.hasPermission("ae.admin")) {
                if (args[0].equalsIgnoreCase("help")) {
                    String prefix = main.getConfig().getString("Messages.tag-prefix");
                    prefix = prefix.replaceAll("&", "§");
                            sender.sendMessage("\n" + prefix);
                    sender.sendMessage("/ae give [player] [quantity] | you the custom item");
                    sender.sendMessage("/ae reload | the config");
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    main.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Config Reloaded!");
                    return true;
                }
                if (args.length == 3)
                    if (Bukkit.getPlayer(args[1]) != null) {
                        Player target = Bukkit.getPlayer(args[1]);
                        String typeItem = main.getConfig().getString("Fearsight.customItem");
                        typeItem = typeItem.toUpperCase();
                        if (Material.getMaterial(typeItem) != null) {
                            ItemStack item = new ItemStack(Material.getMaterial(typeItem), Integer.parseInt(args[2]));
                            ItemMeta itemMeta = item.getItemMeta();
                            String lore = main.getConfig().getString("Fearsight.lore-for-Fearsight");
                            lore = lore.replaceAll("&", "§");
                                    itemMeta.setDisplayName("§cFearsight I");
                            itemMeta.setLore(Arrays.asList(new String[] { lore }));
                            item.setItemMeta(itemMeta);
                            PlayerInventory inv = target.getInventory();
                            inv.addItem(new ItemStack[] { item });
                            return true;
                        }
                        Bukkit.broadcastMessage("item type.");
                    } else {
                        Bukkit.broadcastMessage("player.");
                    }
            }
        return false;
    }
}
