package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class Topic2_Security_Master {
    public static void main(String[] args) {
        String jarPath = "C:\\\\Users\\\\AI_CEC_10\\\\Desktop\\\\cec 4sem java p\\\\day5\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0.jar";
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");
                Connection conn = driver.connect(dbUrl, props);

                System.out.println("🛡️ Secure Banking System Online.");

                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "admin");
                pstmt.setString(2, "admin123");

                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) System.out.println("✅ Access Granted: Welcome Admin!");

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}