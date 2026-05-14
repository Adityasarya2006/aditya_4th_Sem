package day4;

class ShapeLogger {

    // Method with (String, int)
    void logShape(String name, int area) {
        System.out.println(name + ": " + area);
    }

    // Overloaded method with (int, String)
    void logShape(int area, String name) {
        System.out.println(area + ": " + name);
    }
}

public class MetaDataLogger {
    public static void main(String[] args) {

        ShapeLogger logger = new ShapeLogger();

        // Calling first method
        logger.logShape("Square", 25);

        // Calling overloaded method
        logger.logShape(25, "Square");
    }
}