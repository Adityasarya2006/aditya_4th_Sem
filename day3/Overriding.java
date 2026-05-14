package day3;

class Device {

    private String color = "Black";

    public String getColor() {
        return color;
    }

    void showBrand() {

        System.out.println("📱 Generic Device in " 
                + color + " color.");
    }
}

class Samsung extends Device {

    @Override
    void showBrand() {

        System.out.println("📱 Samsung Galaxy in Silver color ✨");
    }
}

class Apple extends Device {

    @Override
    void showBrand() {

        System.out.println("📱 Apple iPhone in Space Black 🍎");
    }
}

public class Overriding {

    public static void main(String[] args) {

        System.out.println("--- 📱 DEVICE BRAND SYSTEM ---");

        Device d1 = new Samsung();

        Device d2 = new Apple();

        d1.showBrand();

        d2.showBrand();

        System.out.println("\n💡 LESSON:");
        System.out.println("Method Overriding lets child classes");
        System.out.println("give their own version of a parent's method.");
    }
}