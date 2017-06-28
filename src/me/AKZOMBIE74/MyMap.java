package me.AKZOMBIE74;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

/**
 * Created by Amin on 3/25/2017.
 */
public class MyMap implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
                if (p.hasPermission("marauders.use")) {
                    if (cmd.getName().equalsIgnoreCase("mm")) {
                        ItemStack is = MM.getInstance().createMap();
                        MapView mapView = Bukkit.getMap(is.getDurability());
                        myRender.applyToMap(mapView);
                        p.getInventory().addItem(is);
                        p.sendMessage(ChatColor.GREEN + "Received Marauders Map");
                    }
                }
        }
        return false;
    }
}