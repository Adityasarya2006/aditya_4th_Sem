package day4;

// Interface
interface Encryptable {

    // Abstract method
    void encryptData();
}

// Class implementing the interface
class FileData implements Encryptable {

    @Override
    public void encryptData() {
        System.out.println("Encrypting file data...");
    }
}

// Main class
public class EncryptDemo {

    public static void main(String[] args) {

        FileData file = new FileData();

        file.encryptData();
    }
}