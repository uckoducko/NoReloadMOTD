package com.uckoducko.noreloadmotd;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.uckoducko.noreloadmotd.Main;

public class Events implements Listener {
	
	private Main main1;
	public Events(Main main) {
		this.main1 = main;
	}
	
    @EventHandler(priority =EventPriority.HIGHEST)
    public void pingEvent(ServerListPingEvent e) {
    	main1.reloadConfig();
    	    e.setMotd(ChatColor.translateAlternateColorCodes('&', main1.getConfig().getString("MOTD")));
    }    
}