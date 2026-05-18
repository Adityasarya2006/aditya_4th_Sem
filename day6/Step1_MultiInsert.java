package day6;

import java.sql.*; 
import java.net.URL; 
import java.net.URLClassLoader; 
import java.util.Properties; 

public class Step1_MultiInsert {
    public static void main(String[] args) {

        String jarPath = "C:\\\\\\\\Users\\\\\\\\AI_CEC_10\\\\\\\\Desktop\\\\\\\\cec 4sem java p\\\\\\\\day5\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\mysql-connector-j-9.7.0.jar";
        
        // 📍 Address of our Day 6 Database
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
  
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                Statement stmt = conn.createStatement();

                System.out.println("🍎 [ACTION]: Opening Tech Store... Stocking products.");

                stmt.executeUpdate("INSERT INTO products (pname, price) VALUES ('iPhone 15', 79999.00)");
                stmt.executeUpdate("INSERT INTO products (pname, price) VALUES ('MacBook Air', 95000.00)");
                stmt.executeUpdate("INSERT INTO products (pname, price) VALUES ('AirPods Pro', 24000.00)");

                System.out.println("✅ [RESULT]: 3 Premium items added! Check your XAMPP products table now.");
                
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}