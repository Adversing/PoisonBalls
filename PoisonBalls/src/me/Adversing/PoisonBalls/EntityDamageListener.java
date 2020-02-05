package me.Adversing.PoisonBalls;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class EntityDamageListener implements Listener
{
    public EntityDamageListener(PoisonBalls instance) {
        instance.getServer().getPluginManager().registerEvents(this,instance);
    }
    
    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player && e.getDamager().hasMetadata("poisonballs")) {
            Player target = (Player)e.getEntity();
            target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, PoisonBalls.getPluginConfig().getInt("poisonball.seconds") * 20, 0));
        }
    }
}
