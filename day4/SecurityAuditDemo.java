package day4;


interface Encryptable {

    void encryptData();
}

class PaymentMethod {

    public void pay() {
        System.out.println("Processing payment...");
    }
}

class CreditCard extends PaymentMethod implements Encryptable {

    @Override
    public void encryptData() {
        System.out.println("Encrypting credit card details...");
    }
}

class Cash extends PaymentMethod {

}

class OnlineWallet extends PaymentMethod implements Encryptable {

    @Override
    public void encryptData() {
        System.out.println("Encrypting online wallet data...");
    }
}

public class SecurityAuditDemo {

    public static void main(String[] args) {

        PaymentMethod[] payments = {
            new CreditCard(),
            new Cash(),
            new OnlineWallet()
        };

        for (PaymentMethod p : payments) {

            p.pay();

            if (p instanceof Encryptable) {

                Encryptable e = (Encryptable) p;

                e.encryptData();
            }
            else {
                System.out.println("No encryption supported.");
            }

            System.out.println();
        }
    }
}