package day4;

// Abstract class
abstract class Shape {

    // Abstract methods (must be implemented)
    abstract double calculateArea();

    abstract void draw();
}

// Concrete class
class Triangle extends Shape {

    double base;
    double height;

    // Constructor
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implement calculateArea()
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    // Implement draw()
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Main class
public class TriangleDemo {

    public static void main(String[] args) {

        Triangle t1 = new Triangle(10, 5);

        t1.draw();

        System.out.println("Area of Triangle: " + t1.calculateArea());
    }
}