package day3;

public class BasicPhone {

    private String brand;
    private String model;

    public BasicPhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // 🟢 GETTERS to read the data
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    public void makeCall(String number) {
        System.out.println("☎️ Calling " + number + " using " + brand + " phone...");
    }

    public void sendMessage(String number, String text) {
        System.out.println("✉️ Sending SMS to " + number + ": " + text);
    }
}