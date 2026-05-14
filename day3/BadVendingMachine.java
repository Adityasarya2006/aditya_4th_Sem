package day3;

public class BadVendingMachine { 

    public double totalCashInMachine; 
    public int productStock;       

    public static void main(String[] args) { 

        BadVendingMachine machine = new BadVendingMachine();

        machine.totalCashInMachine = 5000.0;
        machine.productStock = 50;

        System.out.println("--- 🟢 INITIAL MACHINE STATE ---");
        System.out.println("Cash: Rs." + machine.totalCashInMachine);
        System.out.println("Stock: " + machine.productStock + " items");

        System.out.println("\n--- 🔴 AN ATTACKER ARRIVES! ---");

        machine.totalCashInMachine = 0.0; 
        machine.productStock = -99;    

        System.out.println("Cash Left: Rs." + machine.totalCashInMachine);
        System.out.println("Stock Left: " + machine.productStock);
        
        System.out.println("\n💡 LESSON: This business failed because the data was NOT hidden (Private).");
    }
}