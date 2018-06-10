package me.specifies.core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.specifies.core.DeluxeTabs;
import me.specifies.core.Methods;



public class TabPrefix implements CommandExecutor{
	DeluxeTabs plugin;
	public TabPrefix(DeluxeTabs instance) {
		this.plugin = instance;
	}
	Methods me = new Methods(plugin);
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player p = (Player) sender;
    	String pmsg = plugin.getConfig().getString("command-prefix");
    	String gtitle = plugin.getConfig().getString("gui-prefix");
    	if(cmd.getName().equalsIgnoreCase("tabprefix")) {
    		if(p.hasPermission("deluxtabs.tabprefix")) {
    			p.sendMessage(plugin.color(pmsg + " &7Opening prefix GUI."));
    			me.openInventory(p, gtitle, 45);
    		} 
    		else {
    			p.sendMessage(plugin.color(pmsg + " &7It appears you do not have access to this command."));
    		}
    	}
        return true;
    }

}
