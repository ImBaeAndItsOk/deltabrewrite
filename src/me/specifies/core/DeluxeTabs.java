package me.specifies.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.specifies.core.Commands.TabPrefix;
import me.specifies.core.Events.setDefaultFile;
import me.specifies.core.Events.setPrefix;
import net.milkbowl.vault.chat.Chat;


public class DeluxeTabs extends JavaPlugin{
	private static Chat chat;
	public void onEnable() {
		registerEvents();
		createConfigs();
		registerCommands();
		setUpChat();
	}
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new setPrefix(this), this);
		pm.registerEvents(new setDefaultFile(this), this);
	}
	public void registerCommands() {
		getCommand("tabprefix").setExecutor(new TabPrefix(this));
	}
	
	public void createConfigs() {
		FileConfiguration config = this.getConfig();
		config.addDefault("command-prefix", "&7[&bDeluxe&cTabs&7]");
		config.addDefault("gui-prefix", "&bDeluxe&cTabs");
		config.options().copyDefaults(true);
	}
	
	//utils
	public String color(String m) {
		return ChatColor.translateAlternateColorCodes('&', m);
	}
	public void message(String m) {
		getServer().getConsoleSender().sendMessage(m);
	}
	
	
	private boolean setUpChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
	}
	public static Chat getChat() {
		return chat;
	}
}
