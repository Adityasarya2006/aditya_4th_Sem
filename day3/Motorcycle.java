package day3;

class Vehicle {

    // Method in parent class
    public void startEngine() {

        System.out.println("🚗 Engine started...");
    }
}

// Child Class
public class Motorcycle extends Vehicle {

    // Method in child class
    public void wheelie() {

        System.out.println("🏍️ Motorcycle is doing a wheelie!");
    }

    public static void main(String[] args) {

        // Creating child class object
        Motorcycle bike = new Motorcycle();

        // Calling parent class method
        bike.startEngine();

        // Calling child class method
        bike.wheelie();

        System.out.println("\n💡 CONCLUSION:");
        System.out.println("Motorcycle inherited startEngine() from Vehicle.");
    }
}