package capitaliul.capitalium.event;

import capitaliul.capitalium.Capitalium;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;
import org.bukkit.event.block.Action;

import org.bukkit.block.BlockFace;

import java.util.List;

public class OnMine implements Listener {


    @EventHandler
    public void updateOnInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && !p.isSneaking()) {
            Block centerBlock = event.getClickedBlock();
            double xOffset = 0.5D;
            double yOffset = 0.5D;
            double zOffset = 0.5D;
            if (true) {
                BlockFace bf = getBlockFace(p);
                Block[] blocks = getBlocks(bf, centerBlock);
                if (bf == BlockFace.UP || bf == BlockFace.DOWN)
                    if (bf == BlockFace.UP) {
                        yOffset += 0.6D;
                    } else {
                        yOffset -= 0.6D;
                    }
                if (bf == BlockFace.NORTH || bf == BlockFace.SOUTH)
                    if (bf == BlockFace.SOUTH) {
                        zOffset += 0.6D;
                    } else {
                        zOffset -= 0.6D;
                    }
                if (bf == BlockFace.EAST || bf == BlockFace.WEST)
                    if (bf == BlockFace.EAST) {
                        xOffset += 0.6D;
                    } else {
                        xOffset -= 0.6D;
                    }
                byte b;
                int i;
                Block[] arrayOfBlock1;
                for (i = (arrayOfBlock1 = blocks).length, b = 0; b < i; ) {
                    Block block = arrayOfBlock1[b];
                    ItemStack pick = p.getInventory().getItemInMainHand();
                    if (block != null && block.isPreferredTool(pick)) {
                        Location bLoc = block.getLocation();
                        bLoc.setX(bLoc.getX() + xOffset);
                        bLoc.setY(bLoc.getY() + yOffset);
                        bLoc.setZ(bLoc.getZ() + zOffset);
                        if (true)
                            bLoc.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, bLoc, 1);
                    }
                    b++;
                }
            }
        }
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        Player player = event.getPlayer();
        int[] blockallowed = { 1, 14, 15, 16, 21, 56, 73, 74, 129 };
        if (true) {
            System.out.println("miue");

            Block centerBlock = event.getBlock();
            BlockFace bf = getBlockFace(player);
            Block[] blocks = getBlocks(bf, centerBlock);
            byte b;
            int i;
            Block[] arrayOfBlock1;
            for (i = (arrayOfBlock1 = blocks).length, b = 0; b < i; ) {
                Block block = arrayOfBlock1[b];
                ItemStack pick = player.getInventory().getItemInMainHand();
                if (true)
                    if (true) {
                        if (true) {
                            System.out.printf("mia");
                           // pickDamage.damage(pickDamage.getHealth() + 1);
                            block.breakNaturally(pick);
                            //pick.setItemMeta((ItemMeta)pickDamage);
                        }
                    }
                b++;
            }


        }
    }




    public BlockFace getBlockFace(Player player) {
        List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !((Block)lastTwoTargetBlocks.get(1)).getType().isOccluding())
            return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }



    public Block[] getBlocks(BlockFace bf, Block center) {
        Block[] blocks = new Block[8];
        int x = center.getX();
        int y = center.getY();
        int z = center.getZ();
        if (bf == BlockFace.UP || bf == BlockFace.DOWN) {
            blocks[0] = center.getWorld().getBlockAt(x - 1, y, z - 1);
            blocks[1] = center.getWorld().getBlockAt(x - 1, y, z);
            blocks[2] = center.getWorld().getBlockAt(x - 1, y, z + 1);
            blocks[3] = center.getWorld().getBlockAt(x, y, z - 1);
            blocks[4] = center.getWorld().getBlockAt(x, y, z + 1);
            blocks[5] = center.getWorld().getBlockAt(x + 1, y, z - 1);
            blocks[6] = center.getWorld().getBlockAt(x + 1, y, z);
            blocks[7] = center.getWorld().getBlockAt(x + 1, y, z + 1);
        }
        if (bf == BlockFace.NORTH || bf == BlockFace.SOUTH) {
            blocks[0] = center.getWorld().getBlockAt(x - 1, y + 1, z);
            blocks[1] = center.getWorld().getBlockAt(x, y + 1, z);
            blocks[2] = center.getWorld().getBlockAt(x + 1, y + 1, z);
            blocks[3] = center.getWorld().getBlockAt(x - 1, y, z);
            blocks[4] = center.getWorld().getBlockAt(x + 1, y, z);
            blocks[5] = center.getWorld().getBlockAt(x - 1, y - 1, z);
            blocks[6] = center.getWorld().getBlockAt(x, y - 1, z);
            blocks[7] = center.getWorld().getBlockAt(x + 1, y - 1, z);
        }
        if (bf == BlockFace.EAST || bf == BlockFace.WEST) {
            blocks[0] = center.getWorld().getBlockAt(x, y + 1, z - 1);
            blocks[1] = center.getWorld().getBlockAt(x, y + 1, z);
            blocks[2] = center.getWorld().getBlockAt(x, y + 1, z + 1);
            blocks[3] = center.getWorld().getBlockAt(x, y, z - 1);
            blocks[4] = center.getWorld().getBlockAt(x, y, z + 1);
            blocks[5] = center.getWorld().getBlockAt(x, y - 1, z - 1);
            blocks[6] = center.getWorld().getBlockAt(x, y - 1, z);
            blocks[7] = center.getWorld().getBlockAt(x, y - 1, z + 1);
        }
        return blocks;
    }

}