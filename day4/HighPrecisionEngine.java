package day4;

class Shape {

    // Method for Circle
    void calculateArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle = " + area);
    }

    // Overloaded method for Triangle
    void calculateArea(float base, float height) {
        float area = 0.5f * base * height;
        System.out.println("Area of Triangle = " + area);
    }
}

public class HighPrecisionEngine {
    public static void main(String[] args) {

        Shape shape = new Shape();

        // Circle area
        shape.calculateArea(7.5);

        // Triangle area
        shape.calculateArea(10.0f, 6.0f);
    }
}