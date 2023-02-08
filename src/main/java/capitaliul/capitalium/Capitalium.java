package capitaliul.capitalium;

import capitaliul.capitalium.command.CommandKit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Capitalium extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        config.addDefault("Enable", true);
        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("kit").setExecutor(new CommandKit());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
