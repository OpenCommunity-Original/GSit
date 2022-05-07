package dev.geco.gsit.link;

import java.util.*;

import org.jetbrains.annotations.NotNull;

import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.expansion.*;

import dev.geco.gsit.GSitMain;

public class PAPILink extends PlaceholderExpansion {

    private final GSitMain GPM;

    public PAPILink(GSitMain GPluginMain) { GPM = GPluginMain; }

    @Override
    public boolean canRegister() { return GPM.isEnabled(); }

    @Override
    public @NotNull String getName() { return GPM.getDescription().getName(); }

    @Override
    public @NotNull String getIdentifier() { return GPM.NAME.toLowerCase(); }

    @Override
    public @NotNull String getAuthor() { return GPM.getDescription().getAuthors().toString(); }

    @Override
    public @NotNull String getVersion() { return GPM.getDescription().getVersion(); }

    @Override
    public @NotNull List<String> getPlaceholders() { return Arrays.asList("toggle", "playertoggle"); }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {

        if(player == null || params == null) return null;

        if(params.equalsIgnoreCase("toggle")) return "" + GPM.getToggleManager().canSit(player.getUniqueId());

        if(params.equalsIgnoreCase("playertoggle")) return "" + GPM.getToggleManager().canPlayerSit(player.getUniqueId());

        return null;
    }
}