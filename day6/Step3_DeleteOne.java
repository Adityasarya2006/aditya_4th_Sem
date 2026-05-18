package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader; 
import java.util.Properties; 

public class Step3_DeleteOne {
    public static void main(String[] args) {

        String jarPath = "C:\\\\\\\\Users\\\\\\\\AI_CEC_10\\\\\\\\Desktop\\\\\\\\cec 4sem java p\\\\\\\\day5\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\mysql-connector-j-9.7.0.jar";

        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});
                
                System.out.println("🗑️ [ACTION]: Processing Sale... Removing 'AirPods Pro' from stock.");

                String sql = "DELETE FROM products WHERE pname = 'AirPods Pro'";

                int rowsAffected = conn.createStatement().executeUpdate(sql);

                if(rowsAffected > 0) {
                    System.out.println("✅ [RESULT]: 'AirPods Pro' sold and removed from inventory database.");
                } else {
                    System.out.println("⚠️ [NOTICE]: Item 'AirPods Pro' was not found in the shop.");
                }

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}