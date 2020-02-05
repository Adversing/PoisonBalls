package me.Adversing.PoisonBalls;

import java.util.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.metadata.*;
import org.bukkit.configuration.*;
import org.bukkit.event.*;

public class ThrowListener implements Listener
{
    public ThrowListener(PoisonBalls instance) {
    	new HashMap<String, Long>();
        instance.getServer().getPluginManager().registerEvents(this,instance);
    }
    
    @EventHandler
    public void onLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof Snowball && e.getEntity().getShooter() instanceof Player) {
            Snowball snowball = (Snowball)e.getEntity();
            Player player = (Player)e.getEntity().getShooter();
            Configuration config = PoisonBalls.getPluginConfig();
            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translate(config.getString("poisonball.name"))) && player.hasPermission("poisonball.use")) {
                snowball.setMetadata("poisonballs", new FixedMetadataValue(PoisonBalls.getInstance(), true));
            }
        }
    }
}