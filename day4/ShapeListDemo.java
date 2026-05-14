package day4;

import java.util.ArrayList;
import java.util.List;

// Abstract class
abstract class Shape {

    abstract double calculateArea();

    abstract void draw();

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

    @Override
    String getDescription() {
        return "This is a Circle";
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

    @Override
    String getDescription() {
        return "This is a Rectangle";
    }
}

// Triangle class
class Triangle extends Shape {

    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    String getDescription() {
        return "This is a Triangle";
    }
}

// Main class
public class ShapeListDemo {

    public static void main(String[] args) {

        // List of Shape references
        List<Shape> shapes = new ArrayList<>();

        // Adding different shape objects
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(4, 6));
        shapes.add(new Triangle(10, 5));

        // Loop through all shapes
        for (Shape shape : shapes) {

            System.out.println(shape.getDescription());

            shape.draw();

            System.out.println("Area: " + shape.calculateArea());

            System.out.println();
        }
    }
}