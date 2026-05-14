package day3;

public class SmartPhone extends BasicPhone {
    
    private boolean has5G;
    private int cameraMP;

    public SmartPhone(String brand, String model, int cameraMP) {
  
        super(brand, model);
        this.cameraMP = cameraMP;
    }

    public void browseInternet() {

        System.out.println("🌐 Browsing the web on " + getModel() + "...");
    }

    public void takePhoto() {
        System.out.println("📸 Taking a photo with " + cameraMP + "MP camera!");
    }

    public static void main(String[] args) {

        SmartPhone myPhone = new SmartPhone("Apple", "iPhone 15", 48);
        

        myPhone.makeCall("9999912345");
        
        myPhone.takePhoto();
        myPhone.browseInternet();
        
        System.out.println("\n💡 CONCLUSION: Inheritance + Encapsulation = Clean, Secure Code!");
    }
}