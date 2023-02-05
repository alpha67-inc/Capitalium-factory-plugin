package capitalium.capitalium.event;

import capitalium.capitalium.Capitalium;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.C;

public class OnMine implements Listener {

    private static Capitalium plugin;

    public OnMine(Capitalium instance) {
        plugin = instance;
    }



    @EventHandler
    public void onMine(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        int[] blockallowed = { 1, 14, 15, 16, 21, 56, 73, 74, 129 };
        if (player.getGameMode() == GameMode.SURVIVAL &&
                player.getItemInHand().getType() == Material.GOLDEN_PICKAXE &&
                player.getItemInHand().getItemMeta().hasDisplayName() &&
                player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("hammer")) {
            byte b;
            int i;
            int[] arrayOfInt;
            for (i = (arrayOfInt = blockallowed).length, b = 0; b < i; ) {
                int j = arrayOfInt[b];
                World world = player.getWorld();
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        for (int z = -1; z < 2; z++) {
                            Block blockAtLoc = world.getBlockAt(block.getLocation().getBlockX() + x,
                                    block.getLocation().getBlockY() + y, block.getLocation().getBlockZ() + z);
                            if (blockAtLoc.getBlockPower() == j)
                                blockAtLoc.breakNaturally(new ItemStack(Material.DIAMOND_PICKAXE));
                        }
                    }
                }
                b++;
            }
        }
    }

}