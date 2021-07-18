package de.spigotapi.secrets.start;

import de.spigotapi.secrets.start.gui.SecretListCommand;
import de.spigotapi.secrets.start.listener.ClickedListener;
import de.spigotapi.secrets.start.listener.JoinListener;
import de.spigotapi.secrets.start.mysql.Connection;
import de.spigotapi.secrets.start.api.SecretAPI;
import de.spigotapi.secrets.start.signs.LamaSecret;
import org.bukkit.plugin.java.JavaPlugin;

public final class Start extends JavaPlugin {

    private void registerCommands() {
        getCommand("secret").setExecutor(new SecretListCommand());
    }

    private void registerSigns() {
        getServer().getPluginManager().registerEvents(new LamaSecret(), this);
    }

    private void createMYSQL() {
        SecretAPI.createTableLama();
        SecretAPI.createTableID();
    }



    private void registerListener() {
        getServer().getPluginManager().registerEvents(new ClickedListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    private void connectMYSQL() {
        Connection.connect();
    }

    @Override
    public void onEnable() {

        connectMYSQL();
        createMYSQL();
        registerSigns();
        registerListener();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
