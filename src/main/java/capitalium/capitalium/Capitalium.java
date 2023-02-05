package capitalium.capitalium;

import capitalium.capitalium.command.CommandManager;
import capitalium.capitalium.event.OnMine;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Capitalium extends JavaPlugin {

    public static Capitalium plugin;

    private final OnMine onmine = new OnMine(this);

    @Override
    public void onEnable() {

        this.getCommand("kit").setExecutor(new CommandManager());

        getServer().getPluginManager().registerEvents(onmine, this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Capitalium Factory plugin succifuly lauch");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
