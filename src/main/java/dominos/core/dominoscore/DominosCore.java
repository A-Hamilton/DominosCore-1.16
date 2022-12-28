package dominos.core.dominoscore;

import dominos.core.dominoscore.commands.Discord;
import dominos.core.dominoscore.commands.Features;
import dominos.core.dominoscore.events.ClearStack;
import dominos.core.dominoscore.events.JoinEvent;
import dominos.core.dominoscore.features.*;
import dominos.core.dominoscore.patches.EastWest;
import dominos.core.dominoscore.patches.MovementFix;
import dominos.core.dominoscore.patches.NetheriteBreaker;
import dominos.core.dominoscore.features.MagicSand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DominosCore extends JavaPlugin {

    private static DominosCore instance;

    public static DominosCore getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        
        final PluginManager plManager = getServer().getPluginManager();

        plManager.registerEvents(new JoinEvent(), this);
        plManager.registerEvents(new NetheriteBreaker(), this);
        plManager.registerEvents(new DispenserBreak(), this);
        plManager.registerEvents(new ProtectionBlock(), this);
        plManager.registerEvents(new MovementFix(), this);
        plManager.registerEvents(new EastWest(), this);
        plManager.registerEvents(new MagicSand(this), this);
        plManager.registerEvents(new ClearStack(), this);
//        getServer().getPluginManager().registerEvents(new Fire(), this);

        getCommand("tntfill").setExecutor(new Tntfill(this));
        getCommand("tf").setExecutor(new Tntfill(this));
        getCommand("discord").setExecutor(new Discord(this));
        getCommand("ce").setExecutor(new ClearEntities(this));
        getCommand("features").setExecutor(new Features(this));
        getCommand("magicsand").setExecutor(new MagicSand(this));
        getCommand("ms").setExecutor(new MagicSand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
