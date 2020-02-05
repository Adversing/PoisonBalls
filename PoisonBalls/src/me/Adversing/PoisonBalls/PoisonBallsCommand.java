package me.Adversing.PoisonBalls;

import org.bukkit.command.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.configuration.*;
import org.bukkit.inventory.meta.*;

public class PoisonBallsCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("snowball") && sender.hasPermission("poisonball.give")) {
            final Configuration config = PoisonBalls.getPluginConfig();
            if (args.length == 3 && args[0].equalsIgnoreCase("give") && Bukkit.getServer().getPlayer(args[1]) != null) {
                ItemStack snowball = new ItemStack(Material.SNOW_BALL, Integer.parseInt(args[2]));
                ItemMeta meta2 = snowball.getItemMeta();
                meta2.setDisplayName(ChatColor.translate(config.getString("poisonball.name")));
                meta2.setLore(Arrays.asList(ChatColor.translate(config.getString("poisonball.lore"))));
                snowball.setItemMeta(meta2);
                Bukkit.getPlayer(args[1]).getInventory().addItem(new ItemStack[] { snowball });
                return true;
            }
            sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "Incorrect usage! /snowball give (player) (amount).");
        }
        return false;
    }
}
