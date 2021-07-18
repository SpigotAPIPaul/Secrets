package de.spigotapi.secrets.start.gui;

import de.spigotapi.secrets.start.api.SecretAPI;
import de.spigotapi.secrets.start.api.Creator;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SecretListCommand implements CommandExecutor {

    ArrayList<String> LamaLore = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 30.0F, 30.0F);
            Inventory inv = Bukkit.createInventory(null, 54, "§8» §5§lSECRETS §8┃ §d§oMenü");

            for (int i = 9; i < 18; i++) {

                ItemStack nop5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.PURPLE.getData());
                ItemMeta im = nop5.getItemMeta();

                im.setDisplayName("§c-");
                nop5.setItemMeta(im);
                inv.setItem(i, nop5);

            }

            for (int i = 18; i < 54; i++) {

                ItemStack nop = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
                ItemMeta im = nop.getItemMeta();

                im.setDisplayName("§c-");
                nop.setItemMeta(im);
                inv.setItem(i, nop);

            }

            ItemStack no = new ItemStack(Material.STORAGE_MINECART, 1);
            ItemMeta im2 = no.getItemMeta();

            no.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 0);
            im2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im2.setDisplayName("§8» §d§lLOBBY§8-§d§lSECRETS §8┃ §7§oKlicken");
            no.setItemMeta(im2);

            inv.setItem(0, no);

            LamaLore.clear();
            LamaLore.add("");

            if (SecretAPI.isRegisteredLama(p)) {
                LamaLore.add("§8➥ §aFreigeschaltet");
                LamaLore.add("");
            } else {
                LamaLore.add("§8➥ §cNicht freigeschaltet");
                LamaLore.add("");
            }

            inv.setItem(18, Creator.itemcreator(Material.INK_SACK, DyeColor.LIME.getData(), "§8» §5§lSECRETS §8┃ §a§oLamaSuche",1, (short)0, LamaLore));

            ItemStack alllobbysecrets = new ItemStack(Material.EYE_OF_ENDER, 1);
            ItemMeta alllobbysecretsmeta = alllobbysecrets.getItemMeta();

            alllobbysecretsmeta.setDisplayName("§5§lANZAHL §8» §7" + SecretAPI.getID(p) + " §8┃ §d1");
            alllobbysecrets.setItemMeta(alllobbysecretsmeta);

            inv.setItem(53, alllobbysecrets);

            p.openInventory(inv);

        }
        return false;
    }
}
