package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class Task2_VIPSearch {

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

                System.out.println("🌟 [ACTION]: Searching for VIP Guests...");

                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM hotel_bookings WHERE price > 4000"
                );

                System.out.println("\n📋 VIP Guest List:");
                System.out.println("-----------------------------------");

                while (rs.next()) {

                    int bid = rs.getInt("bid");
                    String guestName = rs.getString("guest_name");
                    int roomNo = rs.getInt("room_no");
                    double price = rs.getDouble("price");

                    System.out.println(
                            "Booking ID: " + bid +
                            " | Guest: " + guestName +
                            " | Room: " + roomNo +
                            " | Price: ₹" + price
                    );
                }

                System.out.println("-----------------------------------");
                System.out.println("✅ [RESULT]: VIP Search Completed!");
                System.out.println("📋 Verify in XAMPP → Rahul should appear.");

                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}