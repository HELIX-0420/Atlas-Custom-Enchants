package me.helix.atlasenchants.Commands;

import me.helix.atlasenchants.GUIS.Shop;
import me.helix.atlasenchants.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    private Main main;
    public ShopCommand (Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;

        Shop shop = new Shop(main);
        shop.build(player);
        shop.show(player);
        player.updateInventory();

        return false;
    }

}
