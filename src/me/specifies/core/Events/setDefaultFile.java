package me.specifies.core.Events;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.specifies.core.DeluxeTabs;

public class setDefaultFile implements Listener {
	DeluxeTabs plugin;
	public setDefaultFile(DeluxeTabs instance) {
		this.plugin = instance;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID u = p.getUniqueId();
		File folder = new File(plugin.getDataFolder()+File.separator+"players");
		if(!folder.exists()) folder.mkdirs();
		File pf = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + u + ".yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(pf);
		if(!p.hasPlayedBefore()) {
		conf.set("custom-prefix", false);
		conf.set("current-prefix", "");
		try {
			conf.save(pf);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

}
