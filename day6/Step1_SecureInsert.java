package day6;

import java.sql.*;
import java.net.URL; 
import java.net.URLClassLoader; 
import java.util.Properties; 


public class Step1_SecureInsert {
    public static void main(String[] args) {

        String jarPath = "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\AI_CEC_10\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\cec 4sem java p\\\\\\\\\\\\\\\\day5\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0.jar";

        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Initializing Secure Member Portal...");

                String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, "Secure_User_01");

                ps.setString(2, "Pass@9988");

                ps.executeUpdate();
                
                System.out.println("✅ [RESULT]: User registered safely using PreparedStatement (No Hacker can touch this!).");

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}