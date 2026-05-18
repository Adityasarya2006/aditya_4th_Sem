package day6;

import java.sql.*;
import java.net.URL; 
import java.net.URLClassLoader; 
import java.util.Properties;

public class ConnectionCheck {
    public static void main(String[] args) {

        String jarPath = "C:\\\\Users\\\\AI_CEC_10\\\\Desktop\\\\cec 4sem java p\\\\day5\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0.jar";
        

        String serverUrl = "jdbc:mysql://localhost:3306/"; 
        

        String dbName = "day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");

                Connection conn = driver.connect(serverUrl, props);

                Statement stmt = conn.createStatement();
                System.out.println("🔗 [1/4] Connected to MySQL Server successfully!");

                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("📂 [2/4] Database '" + dbName + "' created/verified.");

                stmt.executeUpdate("USE " + dbName);

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE, password VARCHAR(50))");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (pid INT AUTO_INCREMENT PRIMARY KEY, pname VARCHAR(100), price DECIMAL(10,2))");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS hotel_bookings (bid INT AUTO_INCREMENT PRIMARY KEY, guest_name VARCHAR(100), room_no INT, price DECIMAL(10,2))");
                System.out.println("📊 [3/4] Tables (users, products, hotel_bookings) are ready.");

                stmt.executeUpdate("INSERT IGNORE INTO users (username, password) VALUES ('admin', 'admin123')");
                System.out.println("✅ [4/4] Setup Complete! You are ready to start Day 6.");

                conn.close();
            }
        } catch (Exception e) {

            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }
}