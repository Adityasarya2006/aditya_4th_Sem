package day6;

import java.sql.*; 
import java.net.URL;
import java.net.URLClassLoader; 
import java.util.Properties; 

public class Step3_SecureUpdate {
    public static void main(String[] args) {
        // 📍 MySQL JAR Location
        String jarPath = "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\AI_CEC_10\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\cec 4sem java p\\\\\\\\\\\\\\\\day5\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0\\\\\\\\\\\\\\\\mysql-connector-j-9.7.0.jar";
        
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
 
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
         
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Processing Password Reset Request...");

                String sql = "UPDATE users SET password = ? WHERE username = ?";
 
                PreparedStatement ps = conn.prepareStatement(sql);
        
                ps.setString(1, "New_Strong_Pass_2024");
            
                ps.setString(2, "Secure_User_01");

                int rowsAffected = ps.executeUpdate();
         
                if(rowsAffected > 0) {
                    System.out.println("✅ [RESULT]: Password updated securely for 'Secure_User_01'!");
                } else {
                    System.out.println("❌ [RESULT]: User not found. Password reset failed.");
                }

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}