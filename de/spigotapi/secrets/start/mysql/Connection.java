package de.spigotapi.secrets.start.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {
    public static String host = "";
    public static String port = "3306";
    public static String database = "Service";
    public static String username = "Service";
    public static String password = "";


    public static java.sql.Connection con;

    public static boolean isConnected(){
        return con != null;
    }

    public static void connect(){
        if(!isConnected()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
            } catch (SQLException e) {

            }
        }
    }

    public static void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {
        }
    }

    public static PreparedStatement getStatement(String sql){
        if(isConnected()){
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                return ps;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ResultSet getResult(String sql){
        if(isConnected()){
            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = getStatement(sql);
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
