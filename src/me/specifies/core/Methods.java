package me.specifies.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Methods {
	DeluxeTabs plugin;
	public Methods(DeluxeTabs instance) {
		this.plugin = instance;
	}
	public void setPrefix(Player p, String prefix) {
		p.setPlayerListName(prefix);
	}
	public String getPrefix(Player p) {
		return p.getPlayerListName();
	}
	public void openInventory(Player p, String name, int slots) {
		Inventory inv = Bukkit.createInventory(null, slots, plugin.color(name));
		p.openInventory(inv);
	}
}
