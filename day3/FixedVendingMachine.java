package day3;

public class FixedVendingMachine {

    // 1. We lock the data by making it PRIVATE
    private double totalCashInMachine;
    private int productStock;

    public FixedVendingMachine(double initialCash, int initialStock) {
        this.totalCashInMachine = initialCash;
        this.productStock = initialStock;
    }

    public double getTotalCashInMachine() {
        return totalCashInMachine;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int newStock) {
        if (newStock >= 0) {
            this.productStock = newStock;
            System.out.println("✅ Stock updated to: " + newStock);
        } else {
            System.out.println("❌ ERROR: Stock cannot be negative!");
        }
    }

    public static void main(String[] args) {
        FixedVendingMachine machine = new FixedVendingMachine(5000.0, 50);

        System.out.println("--- 🟢 SECURE MACHINE ---");

        System.out.println("Current Cash: Rs." + machine.getTotalCashInMachine());

        machine.setProductStock(-10); 
        machine.setProductStock(100); 

        System.out.println("Final Stock: " + machine.getProductStock());
    }
}
