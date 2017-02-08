package com.uckoducko.noreloadmotd;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.uckoducko.noreloadmotd.Events;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("[NoReloadMOTD] Plugin enabled");
    	Bukkit.getServer().getPluginManager().registerEvents(new Events(this), this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[NoReloadMOTD] Plugin disabled");
	}
	
    @EventHandler(priority=EventPriority.HIGHEST)
    public void pingEvent(ServerListPingEvent e) {
    	reloadConfig();
    	    e.setMotd(ChatColor.translateAlternateColorCodes('&', getConfig().getString("MOTD")));
    }  

}
