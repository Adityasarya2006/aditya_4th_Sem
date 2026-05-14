package day4;


interface Payment {

    boolean processPayment(double amount);  
    void printReceipt(double amount);
    String getPaymentType();

    default void logTransaction(double amount) {
        System.out.println("[AUDIT] Transaction of Rs." + amount + " via " + getPaymentType() + " logged.");
    }
}

class CreditCard implements Payment {
    private String cardNumber;
    private double creditLimit;
    private double balance;

    CreditCard(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.balance = 0;
    }

    @Override
    public boolean processPayment(double amount) {
        if (balance + amount <= creditLimit) {
            balance += amount;
            System.out.println("Credit card charged: Rs." + amount);
            return true;
        }
        System.out.println("Transaction Failed: Credit limit reached!");
        return false;
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("--- CREDIT CARD RECEIPT ---");
        System.out.println("Card: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Amount: Rs." + amount);
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}

class UPI implements Payment {
    private String upiId;
    private double walletBalance;

    UPI(String upiId, double walletBalance) {
        this.upiId = upiId;
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (walletBalance >= amount) {
            walletBalance -= amount;
            System.out.println("UPI payment successful from " + upiId + ": Rs." + amount);
            return true;
        }
        System.out.println("Transaction Failed: Insufficient UPI balance!");
        return false;
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("--- UPI RECEIPT ---");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: Rs." + amount);
    }

    @Override
    public String getPaymentType() {
        return "UPI (PhonePe/GPay)";
    }
}

public class PaymentDemo {

    public static void processAnyPayment(Payment payment, double amount) {
        System.out.println("\n--- Initiating " + payment.getPaymentType() + " ---");

        if (payment.processPayment(amount)) {
            payment.printReceipt(amount);
            payment.logTransaction(amount); 
        }
    }

    public static void main(String[] args) {

        Payment card = new CreditCard("1234567890123456", 50000);
        Payment upi = new UPI("parvam@upi", 5000);

        // One method, multiple behaviors
        processAnyPayment(card, 2500);
        processAnyPayment(upi, 1200);
        processAnyPayment(upi, 6000); 

    }
}