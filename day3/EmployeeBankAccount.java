package day3;

public class EmployeeBankAccount {

    // PUBLIC → Accessible from anywhere
    public String bankName = "State Bank of India";

    // PRIVATE → Accessible only inside this class
    private double accountBalance;

    // PROTECTED → Accessible in same package + subclasses
    protected int employeeId;

    // DEFAULT → Accessible only inside same package
    String branchName = "Bengaluru Main Branch";

    // Constructor
    public EmployeeBankAccount(int empId, double balance) {

        this.employeeId = empId;
        this.accountBalance = balance;
    }

    // Public method to safely view balance
    public double getBalance() {
        return accountBalance;
    }

    // Public method to deposit money
    public void deposit(double amount) {

        if (amount > 0) {

            accountBalance = accountBalance + amount;

            System.out.println("✅ Rs." + amount
                    + " deposited successfully.");

        } else {

            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {

        if (amount <= accountBalance) {

            accountBalance = accountBalance - amount;

            System.out.println("✅ Rs." + amount
                    + " withdrawn successfully.");

        } else {

            System.out.println("❌ Insufficient balance.");
        }
    }

    public static void main(String[] args) {

        EmployeeBankAccount emp1 =
                new EmployeeBankAccount(101, 5000);

        System.out.println("--- 🏦 EMPLOYEE BANK ACCOUNT SYSTEM ---");

        // Accessing public variable
        System.out.println("Bank Name: " + emp1.bankName);

        // Accessing protected variable
        System.out.println("Employee ID: " + emp1.employeeId);

        // Accessing default variable
        System.out.println("Branch Name: " + emp1.branchName);

        // Cannot directly access private variable
        // System.out.println(emp1.accountBalance); ❌ ERROR

        // Accessing private data using public method
        System.out.println("Initial Balance: Rs."
                + emp1.getBalance());

        // Banking operations
        emp1.deposit(2000);

        emp1.withdraw(1500);

        emp1.withdraw(10000);

        // Final balance
        System.out.println("Final Balance: Rs."
                + emp1.getBalance());

       
    }
}