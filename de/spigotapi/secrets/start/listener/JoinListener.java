package de.spigotapi.secrets.start.listener;

import de.spigotapi.secrets.start.api.SecretAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (!SecretAPI.isRegisteredID(p)) {
            SecretAPI.registerID(p);
            SecretAPI.addID(p, 0);
        }

    }

}
