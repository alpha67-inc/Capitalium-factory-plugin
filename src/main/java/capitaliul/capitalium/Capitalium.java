package capitaliul.capitalium;

import capitaliul.capitalium.command.CommandKit;
import capitaliul.capitalium.event.OnMine;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Capitalium extends JavaPlugin {

    public static Capitalium plugin;

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        config.addDefault("Enable", true);
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new OnMine(), this);

        this.getCommand("kit").setExecutor(new CommandKit());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
