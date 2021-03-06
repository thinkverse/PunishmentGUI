package me.noodles.gui.listeners;

import me.noodles.gui.updatechecker.UpdateChecker;
import me.noodles.gui.util.Settings;
import org.bukkit.event.player.*;

import me.noodles.gui.PunishmentGUI;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinEvents implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (PunishmentGUI.getPlugin().getConfig().getBoolean("Update.Enabled")) {
            if (p.hasPermission("punishmentgui.update")) {
                new UpdateChecker(PunishmentGUI.getPlugin(), 52072).getLatestVersion(version -> {
                    if (!PunishmentGUI.getPlugin().getDescription().getVersion().equalsIgnoreCase(version)) {
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                        p.sendMessage(ChatColor.RED + "PunishmentGUI is outdated!");
                        p.sendMessage(ChatColor.RED + "Newest version: " + version);
                        p.sendMessage(ChatColor.RED + "Your version: " + Settings.VERSION);
                        p.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                    }
                });
            }
        }
    }

    @EventHandler
    public void onDevJoin(PlayerJoinEvent e) { //THIS EVENT IS USED FOR DEBUG REASONS ONLY!
        Player p = e.getPlayer();
        if (p.getName().equalsIgnoreCase("Noodles_YT")) {
            p.sendMessage(ChatColor.RED + "BGHDDevelopment Debug Message");
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GREEN + "This server is using " + Settings.NAME + " version " + Settings.VERSION);
            p.sendMessage(" ");
        }
    }

}
