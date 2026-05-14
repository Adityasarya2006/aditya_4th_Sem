package day4;

import java.util.ArrayList;
import java.util.List;

interface MiniStatement {
    void printMiniStatement();
}

abstract class ATMCard {
    protected String cardNumber;
    protected String holderName;

    ATMCard(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    public abstract boolean authenticate(String pin);
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    public void showStatus() {
        System.out.println("ATM Card: " + holderName + " [" + cardNumber + "] - READY");
    }
}

class SavingsATM extends ATMCard implements MiniStatement {

    private double balance;
    private String pin;

    SavingsATM(String cardNumber, String holderName, double balance, String pin) {
        super(cardNumber, holderName);
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean authenticate(String inputPin) {
        return pin.equals(inputPin);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("[Savings ATM] Withdraw Successful. Balance: Rs." + balance);
        } else {
            System.out.println("[Savings ATM] Insufficient Balance.");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("[Savings ATM] Deposit Successful. Balance: Rs." + balance);
    }

    @Override
    public void printMiniStatement() {
        System.out.println("[Savings ATM] Mini Statement -> Current Balance: Rs." + balance);
    }
}

class CurrentATM extends ATMCard {

    private double balance;
    private String pin;

    CurrentATM(String cardNumber, String holderName, double balance, String pin) {
        super(cardNumber, holderName);
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean authenticate(String inputPin) {
        return pin.equals(inputPin);
    }

    @Override
    public void withdraw(double amount) {
        double overdraftLimit = 2000;

        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("[Current ATM] Withdraw Successful. Balance: Rs." + balance);
        } else {
            System.out.println("[Current ATM] Overdraft Limit Exceeded.");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("[Current ATM] Deposit Successful. Balance: Rs." + balance);
    }
}

class ATMMachine {

    private List<ATMCard> cards = new ArrayList<>();

    public void addCard(ATMCard card) {
        cards.add(card);
    }

    public void processATMOperations(double withdrawAmount, String pin) {

        System.out.println("\n=== ATM TRANSACTION START ===");

        for (ATMCard card : cards) {

            card.showStatus();

            if (card.authenticate(pin)) {
                System.out.println("   -> Authentication SUCCESS");

                card.withdraw(withdrawAmount);

                if (card instanceof MiniStatement) {
                    System.out.println("   -> Mini Statement Available");
                    ((MiniStatement) card).printMiniStatement();
                } else {
                    System.out.println("   -> Mini Statement NOT AVAILABLE");
                }

            } else {
                System.out.println("   -> Authentication FAILED");
            }

            System.out.println("--------------------------------------------------");
        }
    }
}

public class SmartATMTrainer {

    public static void main(String[] args) {

        ATMMachine atm = new ATMMachine();

        atm.addCard(new SavingsATM("ATM-101", "Rahul Sharma", 15000, "1234"));
        atm.addCard(new CurrentATM("ATM-202", "Priya Verma", 8000, "5678"));
        atm.addCard(new SavingsATM("ATM-303", "Amit Singh", 5000, "9999"));

        atm.processATMOperations(3000, "1234");

        System.out.println("\n🚀 ATM DEMO COMPLETE: OOP makes banking systems modular and scalable!");
    }
}