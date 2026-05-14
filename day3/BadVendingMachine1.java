package day3;

public class BadVendingMachine1 {

    // PUBLIC → Accessible from anywhere
    public double totalCashInMachine;

    // PRIVATE → Accessible only inside this class
    private int secretPin = 1234;

    // PROTECTED → Accessible in same package + subclasses
    protected int productStock;

    // DEFAULT (no modifier) → Accessible only inside same package
    String machineLocation = "Bengaluru Mall";

    public static void main(String[] args) {

        // Correct object creation
        BadVendingMachine1 machine = new BadVendingMachine1();

        // Accessing public variable
        machine.totalCashInMachine = 5000.0;

        // Accessing protected variable
        machine.productStock = 50;

        // Accessing default variable
        machine.machineLocation = "Airport";

        // Accessing private variable (allowed inside same class)
        machine.secretPin = 9999;

        System.out.println("--- 🟢 INITIAL MACHINE STATE ---");

        System.out.println("Cash: Rs." + machine.totalCashInMachine);

        System.out.println("Stock: " + machine.productStock + " items");

        System.out.println("Location: " + machine.machineLocation);

        System.out.println("Secret PIN: " + machine.secretPin);

        System.out.println("\n--- 🔴 AN ATTACKER ARRIVES! ---");

        // Public data can be modified directly
        machine.totalCashInMachine = 0.0;

        // Protected data can also be modified
        machine.productStock = -99;

        // Default variable modified
        machine.machineLocation = "Unknown";

        // Private variable modified only inside class
        machine.secretPin = 1111;

        System.out.println("Cash Left: Rs." + machine.totalCashInMachine);

        System.out.println("Stock Left: " + machine.productStock);

        System.out.println("Location Left: " + machine.machineLocation);

        System.out.println("New Secret PIN: " + machine.secretPin);

        System.out.println("\n💡 LESSON:");
        System.out.println("public    → accessible everywhere");
        System.out.println("private   → accessible only inside same class");
        System.out.println("protected → same package + subclass");
        System.out.println("default   → same package only");
    }
}