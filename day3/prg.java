package day3;

class Device {
    private String category = "Electronic";
    
    Device(String brand) {
        System.out.println("Initializing " + brand + " " + category + " device...");
    }

    public String getCategory() { return category; }
}

class Computer extends Device {
    Computer(String brand) {
        super(brand);
        System.out.println("Setting up Computer systems...");
    }
}

class Laptop extends Computer {
    Laptop(String brand) {
        super(brand);
        System.out.println("Laptop is ready for mobile use!");
    }

    public static void main(String[] args) {
        System.out.println("--- Starting Multilevel Inheritance Demo ---");
        Laptop myLaptop = new Laptop("Dell");

        System.out.println("Device Category: " + myLaptop.getCategory());
    }
}
