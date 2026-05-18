package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.Scanner;

public class Topic5SecurityMaster {
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

                System.out.println("⬆️ Task 4: Role Elevation System Online");

                System.out.print("Enter Student ID: ");
                int studentId = sc.nextInt();

                String sql = "UPDATE users SET role = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, "Instructor");
                pstmt.setInt(2, studentId);

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("✅ Success: Role changed to 'Instructor'");
                } else {
                    System.out.println("❌ Error: Student ID not found");
                }

                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}