package day4;


interface Encryptable {

    void encryptData();

    default void showSecurityLevel() {
        System.out.println("Standard Encryption");
    }
}

class CreditCard implements Encryptable {

    @Override
    public void encryptData() {
        System.out.println("Encrypting credit card information...");
    }
}

class UserAccount implements Encryptable {

    @Override
    public void encryptData() {
        System.out.println("Encrypting user account details...");
    }
}

public class DefaultMethodDemo {

    public static void main(String[] args) {

        CreditCard card = new CreditCard();
        UserAccount user = new UserAccount();

        card.encryptData();

        card.showSecurityLevel();

        System.out.println();

        user.encryptData();
        user.showSecurityLevel();
    }
}