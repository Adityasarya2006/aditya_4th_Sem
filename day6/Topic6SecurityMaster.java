package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.Scanner;

public class Topic6SecurityMaster {
    public static void main(String[] args) {
        String jarPath = "C:\\Users\\AI_CEC_10\\Desktop\\cec 4sem java p\\day5\\mysql-connector-j-9.7.0\\mysql-connector-j-9.7.0\\mysql-connector-j-9.7.0.jar";
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        Scanner sc = new Scanner(System.in);

        try {
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver")
                        .getDeclaredConstructor().newInstance();

                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");

                Connection conn = driver.connect(dbUrl, props);

                System.out.println("🗑️ Task 5: Account Closure System Online");

                System.out.print("Enter Account ID to delete: ");
                int accountId = sc.nextInt();

                String sql = "DELETE FROM users WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, accountId);

                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("✅ Success: Account deleted successfully");
                } else {
                    System.out.println("❌ Error: Account ID not found");
                }

                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}