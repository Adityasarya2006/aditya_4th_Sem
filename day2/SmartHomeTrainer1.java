package day2;

import java.util.Scanner;

class SmartDevice {

    String deviceName;
    boolean isOn;
    int powerLevel;

    void turnOn() {
        isOn = true;
        System.out.println(">>> [POWER] " + deviceName + " is now ON.");
    }

    void turnOff() {
        isOn = false;
        System.out.println(">>> [POWER] " + deviceName + " is now OFF.");
    }

    // Heater-oriented logic (temperature control)
    void autoAdjust(int temperature) {

        System.out.println("Analyzing room temperature (" + temperature + "°C) for " + deviceName + "...");

        if (temperature < 10) {
            powerLevel = 100;
            System.out.println("Decision: HIGH HEAT (100%) ❄️🔥");
        } 
        else if (temperature < 20) {
            powerLevel = 60;
            System.out.println("Decision: MEDIUM HEAT (60%)");
        } 
        else {
            powerLevel = 20;
            System.out.println("Decision: LOW HEAT (20%) 🌤️");
        }
    }

    void statusReport() {
        String state = isOn ? "ACTIVE" : "INACTIVE";
        System.out.println("[" + deviceName + "] State: " + state + " | Heat Level: " + powerLevel + "%");
    }
}

public class SmartHomeTrainer1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   PARVAM SMART HEATER SYSTEM v3.0  ");
        System.out.println("====================================\n");

        // Heater device
        SmartDevice heater = new SmartDevice();
        heater.deviceName = "Smart Room Heater";

        System.out.print("Enter current hour (0-23): ");
        int hour = scanner.nextInt();

        switch (hour) {

            case 0, 1, 2, 3, 4, 5:
                System.out.println("System: Cold night detected. Heater warming mode ON.");
                heater.turnOn();
                heater.powerLevel = 90;
                break;

            case 6, 7, 8:
                System.out.println("System: Morning chill detected.");
                heater.turnOn();
                heater.powerLevel = 50;
                break;

            case 18, 19, 20, 21, 22, 23:
                System.out.println("System: Evening cold detected. Full heating mode.");
                heater.turnOn();
                heater.powerLevel = 80;
                break;

            default:
                System.out.println("System: Normal temperature range.");
                heater.turnOff();
        }

        System.out.println("\n--- TEMPERATURE SENSOR CHECK ---");
        System.out.print("How many zones to check? ");
        int zones = scanner.nextInt();

        for (int i = 1; i <= zones; i++) {

            System.out.print("Enter Temperature for Zone " + i + " (°C): ");
            int temp = scanner.nextInt();

            if (temp < 18) {
                System.out.println("Cold detected in Zone " + i);
                heater.turnOn();
                heater.autoAdjust(temp);
            } else {
                System.out.println("Zone " + i + " is comfortable.");
            }
        }

        System.out.println("\n--- FINAL SYSTEM STATUS ---");
        heater.statusReport();

        System.out.println("\nSystem shutdown complete. Heater monitoring standby mode.");
        scanner.close();
    }
}