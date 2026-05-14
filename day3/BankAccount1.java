package day3;

public class BankAccount1 {

    private String accountHolderName;
    private double balance;

    public String bankName;

    protected String accountType;

    String branchName;

    public BankAccount1(String holderName,
                       String bankName,
                       String accountType,
                       String branchName,
                       double balance) {

        this.accountHolderName = holderName;
        this.bankName = bankName;
        this.accountType = accountType;
        this.branchName = branchName;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance = balance + amount;

            System.out.println("✅ Rs." + amount
                    + " deposited successfully.");

        } else {

            System.out.println("❌ Invalid amount.");
        }
    }

    public void withdraw(double amount) {

        if (amount <= balance) {

            balance = balance - amount;

            System.out.println("✅ Rs." + amount
                    + " withdrawn successfully.");

        } else {

            System.out.println("❌ Insufficient balance.");
        }
    }

    public void displayAccountInfo() {

        System.out.println("\n🏦 BANK ACCOUNT DETAILS");
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Bank Name      : " + bankName);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Branch Name    : " + branchName);
        System.out.println("Balance        : Rs." + balance);
    }

    public static void main(String[] args) {

        BankAccount1 customer1 =
                new BankAccount1(
                        "Aditya",
                        "SBI Bank",
                        "Savings Account",
                        "Bengaluru Branch",
                        10000);

        customer1.displayAccountInfo();

        customer1.deposit(5000);

        customer1.withdraw(3000);

        customer1.withdraw(20000);

        customer1.displayAccountInfo();

    }
}