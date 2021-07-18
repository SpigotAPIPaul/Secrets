package de.spigotapi.secrets.start.api;

import de.spigotapi.secrets.start.mysql.Connection;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecretAPI {

    public static void createTableLama() {
        try {
            PreparedStatement ps = Connection.getStatement("CREATE TABLE IF NOT EXISTS SecretsLama (Spielername VARCHAR(100), UUID VARCHAR(100))");
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createTableID() {
        try {
            PreparedStatement ps = Connection.getStatement("CREATE TABLE IF NOT EXISTS SecretsID (Spielername VARCHAR(100), UUID VARCHAR(100), ANZAHL INT(100))");
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getID(Player p){
        try{
            PreparedStatement ps = Connection.getStatement("SELECT * FROM SecretsID WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int coins = rs.getInt("ANZAHL");
            rs.close();
            ps.close();
            return coins;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }


    public static void addID(Player p, int coins){
        try{
            PreparedStatement ps = Connection.getStatement("UPDATE SecretsID SET ANZAHL= ? WHERE UUID= ?");
            ps.setInt(1, getID(p) + coins);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void registerID(Player p) {
        try {
            PreparedStatement ps = Connection.getStatement("INSERT INTO SecretsID (Spielername, UUID, ANZAHL) VALUES (?, ?, ?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getUniqueId().toString());
            ps.setInt(3, 0);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }






    public static boolean isRegisteredID(Player p){
        try{
            PreparedStatement ps = Connection.getStatement("SELECT * FROM SecretsID WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            rs.close();
            return user;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static void registerLama(Player p) {
        try {
            PreparedStatement ps = Connection.getStatement("INSERT INTO SecretsLama (Spielername, UUID) VALUES (?, ?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }






    public static boolean isRegisteredLama(Player p){
        try{
            PreparedStatement ps = Connection.getStatement("SELECT * FROM SecretsLama WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            rs.close();
            return user;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
