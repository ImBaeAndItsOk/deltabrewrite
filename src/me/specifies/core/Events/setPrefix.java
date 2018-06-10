package me.specifies.core.Events;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.Methods;

public class setPrefix implements Listener{
	DeluxeTabs plugin;
	public setPrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
	Methods me = new Methods(plugin);
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID u = p.getUniqueId();
		File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
		
		boolean isEnabled = conf.getBoolean("custom-prefix");
		if(isEnabled == true) {
			if(p.hasPermission("deluxetabs.customprefix")) {
				String final1 = conf.getString("current-prefix");
				p.setPlayerListName(final1);
			}
		}
		if(isEnabled == false) {
			if(p.hasPermission("deluxetabs.onjoin")) {
				String final1 = DeluxeTabs.getChat().getPlayerPrefix(p);
				p.setPlayerListName(final1);
			}
		}
	}
}
