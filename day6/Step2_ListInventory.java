package day6;

import java.sql.*; 
import java.net.URL; 
import java.net.URLClassLoader; 
import java.util.Properties; 

public class Step2_ListInventory {
    public static void main(String[] args) {

        String jarPath = "C:\\\\Users\\\\AI_CEC_10\\\\Desktop\\\\cec 4sem java p\\\\day5\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0.jar";

        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});
                
                System.out.println("📊 [ACTION]: Generating Tech Store Inventory Report...");

                String sql = "SELECT * FROM products";
                
                ResultSet rs = conn.createStatement().executeQuery(sql);
                
                System.out.println("--------------------------------------");
                

                while(rs.next()) {
  
                    int id = rs.getInt("pid");
                    String name = rs.getString("pname");
                    double price = rs.getDouble("price");

                    System.out.println("📦 ID: " + id + " | Product: " + name + " | Price: ₹" + price);
                }
                
                System.out.println("--------------------------------------");

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}