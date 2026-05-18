package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class Task3_RoomUpgrade {

    public static void main(String[] args) {

        String jarPath =
                "C:\\Users\\AI_CEC_10\\Desktop\\cec 4sem java p\\day5\\mysql-connector-j-9.7.0\\mysql-connector-j-9.7.0\\mysql-connector-j-9.7.0.jar";

        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {

            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));

            try (URLClassLoader loader =
                         new URLClassLoader(new URL[]{jarUrl},
                                 ClassLoader.getSystemClassLoader())) {

                Driver driver = (Driver) loader
                        .loadClass("com.mysql.cj.jdbc.Driver")
                        .getDeclaredConstructor()
                        .newInstance();

                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");

                Connection conn = driver.connect(dbUrl, props);

                Statement stmt = conn.createStatement();

                System.out.println("🏨 [ACTION]: Upgrading Rahul's Room...");

                int rows = stmt.executeUpdate(
                        "UPDATE hotel_bookings " +
                        "SET room_no = 202, price = 7000 " +
                        "WHERE guest_name = 'Rahul'"
                );

                if (rows > 0) {
                    System.out.println("✅ [RESULT]: Rahul upgraded to Room 202 successfully!");
                } else {
                    System.out.println("❌ [RESULT]: Guest Rahul not found.");
                }

                System.out.println("📋 Verify in XAMPP → Check updated room number and price.");

                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}