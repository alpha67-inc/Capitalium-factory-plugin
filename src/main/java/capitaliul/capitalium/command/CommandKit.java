package capitaliul.capitalium.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CommandKit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack
            bricks.setAmount(20);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(gethammer());
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }



    public ItemStack gethammer() {
        ItemStack hammer = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta metahammer = hammer.getItemMeta();
        metahammer.setDisplayName("hammer");
        metahammer.setLore(Arrays.asList(new String[] { "putain de hammer" }));
        metahammer.addEnchant(Enchantment.DIG_SPEED, 1, true);
        metahammer.addEnchant(Enchantment.DURABILITY, 6, true);
        hammer.setItemMeta(metahammer);
        return hammer;
    }

}
