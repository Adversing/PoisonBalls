package me.Adversing.PoisonBalls;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import java.util.*;
import org.bukkit.configuration.*;
import org.bukkit.*;
import java.io.*;

public class PoisonBalls extends JavaPlugin implements Listener
{
    private static PoisonBalls instance;
    List<String> effects;
    public String Configfile;
    
    public PoisonBalls() {
        this.effects = this.getConfig().getStringList("poisonball.Effects");
    }
    
    public void onEnable() {
        this.getLogger().info("Loaded PoisonBall plugin by Adversing");
        (PoisonBalls.instance = this).createConfig();
        this.getCommand("snowball").setExecutor(new PoisonBallsCommand());
        new ThrowListener(this);
        new EntityDamageListener(this);
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.saveConfig();
        getPluginConfig();
    }
    
    public void onDisable() {
    }
    
    public static Configuration getPluginConfig() {
        return Bukkit.getPluginManager().getPlugin("PoisonBalls").getConfig();
    }
    
    private void createConfig() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }
        final File file = new File(this.getDataFolder(), "config.yml");
        if (!file.exists()) {
            this.getLogger().info("Config.yml not found, creating!");
            this.saveDefaultConfig();
        }
        else {
            this.getLogger().info("Config.yml found, loading!");
        }
    }
    
    public static PoisonBalls getInstance() {
        return PoisonBalls.instance;
    }
}
