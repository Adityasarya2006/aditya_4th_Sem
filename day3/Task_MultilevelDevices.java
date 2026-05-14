package day3;


class Device {

    public void powerOn() {

        System.out.println("🔌 Device is powering ON...");
    }
}

class MobileDevice extends Device {

    public void connectWiFi() {

        System.out.println("📶 Mobile connected to WiFi.");
    }
}

class iPhone extends MobileDevice {

    public void useFaceID() {

        System.out.println("😀 Face ID unlocked the iPhone.");
    }
}

public class Task_MultilevelDevices {

    public static void main(String[] args) {

        iPhone myPhone = new iPhone();

        myPhone.powerOn();

        myPhone.connectWiFi();

        myPhone.useFaceID();

        System.out.println("\n💡 CONCLUSION:");
        System.out.println("iPhone inherited features from both Device and MobileDevice.");
    }
}