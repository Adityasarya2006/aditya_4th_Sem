package day4;

interface Encryptable {

    void encryptData();
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


public class SecurityDemo {

    public static void main(String[] args) {

        CreditCard card = new CreditCard();
        UserAccount user = new UserAccount();

        card.encryptData();

        user.encryptData();
    }
}