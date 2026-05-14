package day4;

// Abstract class
abstract class Shape {

    // Abstract methods
    abstract double calculateArea();

    abstract void draw();

    // New abstract method
    abstract String getDescription();
}

// Circle class
class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }

    // Fix: Implement new abstract method
    @Override
    String getDescription() {
        return "This is a Circle shape.";
    }
}

// Rectangle class
class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }

    // Fix: Implement new abstract method
    @Override
    String getDescription() {
        return "This is a Rectangle shape.";
    }
}

// Main class
public class ShapeDemo1 {

    public static void main(String[] args) {

        Circle c = new Circle(5);
        Rectangle r = new Rectangle(4, 6);

        System.out.println(c.getDescription());
        c.draw();
        System.out.println("Circle Area: " + c.calculateArea());

        System.out.println();

        System.out.println(r.getDescription());
        r.draw();
        System.out.println("Rectangle Area: " + r.calculateArea());
    }
}