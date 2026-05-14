package day4;

/**
 * 📝 SIMPLE ENGLISH EXPLANATION:
 * This is the "Grand Finale" program. it combines everything we learned today:
 * 1. An 'Abstract Class' for the shared identity of all payment methods.
 * 2. An 'Interface' for a special capability (Refundable).
 * 3. 'Inheritance' to create specific types like CreditCard and Crypto.
 * 4. 'Runtime Polymorphism' to process all payments in one single loop!
 * 
 * It's like a smart vending machine that can take coins, cards, or phone pay
 * using the same slot logic.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 🚀 Day 4 Master Demo: Smart Payment Ecosystem
 * 
 * This demo integrates:
 * 1. Interfaces (Refundable)
 * 2. Abstract Classes (PaymentMethod)
 * 3. Inheritance (CreditCardProcessor, CryptoProcessor)
 * 4. Runtime Polymorphism (PaymentHub processing different methods)
 * 5. 'instanceof' operator for checking types at runtime
 */

// 1. THE INTERFACE (The Capability)
// Use an interface when you want to add a specific "ability" to some classes.
interface Refundable {
    void processRefund(double amount);
}

// 2. THE ABSTRACT CLASS (The Blueprint)
// Use an abstract class when classes share a "identity" (they are all PaymentMethods).
abstract class PaymentMethod {
    protected String accountId;
    protected String name;

    PaymentMethod(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    // Abstract methods: Every payment MUST authorize and execute, but HOW is specific.
    public abstract boolean authorize(double amount);
    public abstract void execute(double amount);

    // Regular method: Common to all payment methods.
    public void showStatus() {
        System.out.println("Payment Method: " + name + " [" + accountId + "] - READY");
    }
}

// 3. CONCRETE IMPLEMENTATION 1: Credit Card
// Note: It EXTENDS the identity and IMPLEMENTS the refundable ability.
class CreditCardProcessor extends PaymentMethod implements Refundable {
    private double limit;
    private double spent;

    CreditCardProcessor(String id, String name, double limit) {
        super(id, name); // Passing data to parent constructor
        this.limit = limit;
        this.spent = 0;
    }

    @Override
    public boolean authorize(double amount) {
        return (spent + amount) <= limit;
    }

    @Override
    public void execute(double amount) {
        spent += amount;
        System.out.println("[CreditCard] Approved. Total Spent: Rs." + spent);
    }

    @Override
    public void processRefund(double amount) {
        spent -= amount;
        System.out.println("[CreditCard] Refund Successful. New Total Spent: Rs." + spent);
    }
}

// 4. CONCRETE IMPLEMENTATION 2: Crypto Wallet
// Note: It only EXTENDS PaymentMethod. Crypto is not refundable in this demo!
class CryptoProcessor extends PaymentMethod {
    private double balanceBTC;

    CryptoProcessor(String id, String name, double balance) {
        super(id, name);
        this.balanceBTC = balance;
    }

    @Override
    public boolean authorize(double amount) {
        double amountBTC = amount / 5000000; // Mock exchange rate
        return balanceBTC >= amountBTC;
    }

    @Override
    public void execute(double amount) {
        double amountBTC = amount / 5000000;
        balanceBTC -= amountBTC;
        System.out.println("[Crypto] Transaction Sent. Remaining Balance: " + balanceBTC + " BTC");
    }
}

// 5. THE MANAGEMENT HUB (Polymorphism in Action)
class PaymentHub {
    // List of ANY payment method (Abstract Class used as type)
    private List<PaymentMethod> methods = new ArrayList<>();

    public void addMethod(PaymentMethod method) {
        methods.add(method);
    }

    public void processBulkPayments(double amount) {
        System.out.println("\n=== STARTING BULK PAYMENT PROCESSING (Rs." + amount + ") ===");
        
        for (PaymentMethod m : methods) {
            m.showStatus();
            
            // Runtime Polymorphism: Calling authorize() and execute() 
            // without knowing the specific type (CC or Crypto).
            if (m.authorize(amount)) {
                m.execute(amount);
                
                // 💡 RUNTIME TYPE CHECKING:
                // Is this specific method also Refundable?
                if (m instanceof Refundable) {
                    System.out.println("   -> Eligibility: This transaction can be refunded.");
                } else {
                    System.out.println("   -> Eligibility: Final sale. No refunds allowed.");
                }
            } else {
                System.out.println("   -> [FAILED] Denied by provider.");
            }
            System.out.println("--------------------------------------------------");
        }
    }
}

public class SmartPaymentTrainer {
    public static void main(String[] args) {
        PaymentHub hub = new PaymentHub();

        // Adding different types to the hub
        hub.addMethod(new CreditCardProcessor("CC-001", "VISA Gold", 100000));
        hub.addMethod(new CryptoProcessor("BTC-WALL", "Trezor Wallet", 0.05));
        hub.addMethod(new CreditCardProcessor("CC-002", "Amex Black", 5000));

        // Process a payment
        hub.processBulkPayments(7500);
        
        System.out.println("\n🚀 MASTER DEMO COMPLETE: Polymorphism makes systems scalable and clean!");
    }
}