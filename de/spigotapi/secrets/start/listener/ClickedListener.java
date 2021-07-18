package de.spigotapi.secrets.start.listener;

import de.spigotapi.secrets.start.api.SecretAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickedListener implements Listener {


    @EventHandler
    public void LamaSecretClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getWhoClicked().getItemInHand().getType() == Material.INK_SACK) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5§lSECRETS §8┃ §a§oLamaSuche")) {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void AnzahlClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getWhoClicked().getItemInHand().getType() == Material.EYE_OF_ENDER) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lANZAHL §8» §7" + SecretAPI.getID(p) + " §8┃ §d1")) {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void LobbyServerClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getWhoClicked().getItemInHand().getType() == Material.STORAGE_MINECART) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §d§lLOBBY§8-§d§lSECRETS §8┃ §7§oKlicken")) {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void LeerClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getWhoClicked().getItemInHand().getType() == Material.STAINED_GLASS_PANE) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c-")) {
                p.closeInventory();
            }
        }
    }

}
