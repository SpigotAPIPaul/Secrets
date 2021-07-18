package de.spigotapi.secrets.start.signs;

import de.spigotapi.secrets.start.api.SecretAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class LamaSecret implements Listener {



    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("Secret")) {
            if (e.getLine(1).equalsIgnoreCase("LamaSecret")) {
                e.setLine(0, "- §5Secret §0-");
                e.setLine(1, "LamaSecret");
            }
        }
    }


    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player p = e.getPlayer();

            Block b = e.getClickedBlock();
            if (b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN) {

                Sign sign = (Sign) b.getState();
                if (sign.getLine(0).equalsIgnoreCase("- §5Secret §0-")) {
                    if (sign.getLine(1).equalsIgnoreCase("LamaSecret")) {
                        if (SecretAPI.isRegisteredLama(p)) {
                            p.sendMessage("");
                            p.sendMessage("§8» §5§lSecret §8┃ §cDu hast dieses Secret schon freigeschaltet§8!");
                            p.sendMessage("");
                            p.playSound(p.getLocation(), Sound.ANVIL_USE, 100, 100);
                        } else {
                            p.sendMessage("");
                            p.sendMessage("§8» §5§lSecret §8┃ §aSie haben das Secret freigeschaltet§8!");
                            p.sendMessage("");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 100);
                            SecretAPI.registerLama(p);
                            SecretAPI.addID(p, 1);
                        }

                    }
                }
            }


    }


}
