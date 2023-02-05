package capitalium.capitalium.command;

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

public class CommandManager implements CommandExecutor {

    private static final String NO_PERMISSION_MSG = "You do not have the required permissions to do that.";


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player)
        {
            ((Player) sender).getInventory().addItem(gethammer());
        }

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
