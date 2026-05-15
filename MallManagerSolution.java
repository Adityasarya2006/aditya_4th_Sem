package day5;

import java.sql.*;
import java.util.Scanner;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class MallManagerSolution {

    private static final String URL = "jdbc:mysql://localhost:3306/nexus_mall_db";
    private static final String USER = "root"; 
    private static final String PASS = "";      

    private static final String JAR_PATH = "C:\\\\Users\\\\AI_CEC_10\\\\Desktop\\\\cec 4sem java p\\\\day5\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0\\\\mysql-connector-j-9.7.0.jar";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("🚀 Starting Nexus Mall Control Center...");

        if (!loadMySQLDriver()) {
            System.out.println("❌ Failed to load MySQL driver. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View All Shops");
            System.out.println("2. View Total Mall Revenue");
            System.out.println("3. Find Premium Shops");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("👋 Shutting down system. Goodbye!");
                break;
            }

            processChoice(choice);
        }
        sc.close();
    }

    private static boolean loadMySQLDriver() {
        try {

            URL jarUrl = new URL("file:///" + JAR_PATH.replace("\\", "/"));

            URLClassLoader classLoader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader());

            Thread.currentThread().setContextClassLoader(classLoader);

            Class<?> driverClass = classLoader.loadClass("com.mysql.cj.jdbc.Driver");

            Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();

            DriverManager.registerDriver(driver);
            
            System.out.println("✅ MySQL driver loaded successfully!");
            return true;
            
        } catch (Exception e) {
            System.out.println("⚠️ DRIVER LOADING FAILED!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("FIX: Make sure the JAR file exists at: " + JAR_PATH);
            return false;
        }
    }

    private static void processChoice(int choice) {
        try {

            URL jarUrl = new URL("file:///" + JAR_PATH.replace("\\", "/"));
            URLClassLoader classLoader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader());
            Thread.currentThread().setContextClassLoader(classLoader);
            
            Class<?> driverClass = classLoader.loadClass("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
            
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASS);
            
            try (Connection conn = driver.connect(URL, props);
                 Statement stmt = conn.createStatement()) {

                switch (choice) {
                    case 1:
                        ResultSet rsShops = stmt.executeQuery("SELECT * FROM shops");
                        System.out.println("\nID | Name | Category | Rent");
                        while (rsShops.next()) {
                            System.out.printf("%d | %-15s | %-10s | %.2f%n", 
                                rsShops.getInt("shop_id"), 
                                rsShops.getString("name"), 
                                rsShops.getString("category"), 
                                rsShops.getDouble("daily_rent"));
                        }
                        break;

                    case 2:
                        ResultSet rsRev = stmt.executeQuery("SELECT SUM(amount) FROM daily_sales");
                        if (rsRev.next()) {
                            System.out.println("\n💰 Total Revenue: " + rsRev.getDouble(1));
                        }
                        break;

                    case 3:
                        ResultSet rsPrem = stmt.executeQuery("SELECT name FROM shops WHERE daily_rent > 5000");
                        System.out.println("\n💎 PREMIUM SHOPS:");
                        while (rsPrem.next()) {
                            System.out.println("- " + rsPrem.getString("name"));
                        }
                        break;

                    default:
                        System.out.println("❌ Invalid Choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ General Error: " + e.getMessage());
        }
    }
}