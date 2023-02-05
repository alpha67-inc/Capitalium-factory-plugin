package capitaliumfactory.capitalium;

import capitaliumfactory.capitalium.events.OnChunkLoad;
import org.bukkit.plugin.java.JavaPlugin;

public final class Capitalium extends JavaPlugin {

    private static Capitalium instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new OnChunkLoad(), instance);
        System.out.println("le plugin se lance");

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
