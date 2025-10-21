package dev.goodrich.pantheon.listeners;

import com.palmergames.bukkit.towny.event.statusscreen.NationStatusScreenEvent;
import com.palmergames.bukkit.towny.event.statusscreen.TownStatusScreenEvent;
import dev.goodrich.pantheon.util.ReligionCalculator;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ReligionStatusScreenListener implements Listener {

    /**
     * When a town's status screen is built, append the religion breakdown for that town.
     */
    @EventHandler
    public void onTownStatusScreen(TownStatusScreenEvent event) {
        // Retrieve the breakdown (e.g. "Catholic: 50%, Unknown: 50%")
        String breakdown = ReligionCalculator.getTownBreakdown(event.getTown());
        // Append a new component (a new line) to the Town status screen.
        event.getStatusScreen().addComponentOf("religion",
                Component.newline().append(Component.text(ChatColor.DARK_GREEN + "Religion breakdown: " + ChatColor.GREEN + breakdown)));
    }

    /**
     * When a nation's status screen is built, append the overall religion breakdown.
     */
    @EventHandler
    public void onNationStatusScreen(NationStatusScreenEvent event) {
        // Retrieve the breakdown using your calculator.
        String breakdown = ReligionCalculator.getNationBreakdown(event.getNation());
        event.getStatusScreen().addComponentOf("religion",
                Component.newline().append(Component.text(ChatColor.DARK_GREEN + "Religion breakdown: " + ChatColor.GREEN + breakdown)));
    }
}
