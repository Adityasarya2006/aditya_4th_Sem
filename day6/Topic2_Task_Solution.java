package day6;

import java.sql.*; 
import java.net.URL; 
import java.net.URLClassLoader;
import java.util.Properties; 

public class Topic2_Task_Solution {
    public static void main(String[] args) {

        String jarPath = "C:\\\\Users\\\\AI_CEC_10\\\\Desktop\\\\cec 4sem java p\\\\day5\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0.jar";

        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
  
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Security Task Engine Active.");

                String loginSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement ps1 = conn.prepareStatement(loginSQL);

                ps1.setString(1, "admin");
                ps1.setString(2, "admin123");
    
                if(ps1.executeQuery().next()) {
                    System.out.println("✅ [TASK 1]: Secure login successful!");
                }

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}