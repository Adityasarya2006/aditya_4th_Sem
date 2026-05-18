package day6;

import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class Task4_LibraryCleanup {

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

                System.out.println("📚 [ACTION]: Cleaning up free books from library...");

                int rows = stmt.executeUpdate(
                        "DELETE FROM books WHERE price = 0"
                );

                if (rows > 0) {
                    System.out.println("✅ [RESULT]: " + rows + " free book(s) deleted successfully!");
                } else {
                    System.out.println("❌ [RESULT]: No free books found.");
                }

                System.out.println("📋 Verify in XAMPP → Refresh books table.");

                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}