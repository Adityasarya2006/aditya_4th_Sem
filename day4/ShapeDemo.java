package day4;

abstract class Shape {
    String color; 

    public void displayColor() {
        System.out.println("Color: " + color);
    }

    public abstract double calculateArea();

    public abstract void draw();
}

class Circle extends Shape {
    double radius;

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;     
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; 
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    @Override
    public double calculateArea() {
        return length * width; 
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle: " + length + "x" + width);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
  
        Shape c = new Circle(5.0, "Red");     
        Shape r = new Rectangle(4.0, 6.0, "Blue");

        System.out.println("--- Circle Properties ---");
        c.draw();
        System.out.println("Area: " + String.format("%.2f", c.calculateArea()));
        c.displayColor();

        System.out.println("\n--- Rectangle Properties ---");
        r.draw();
        System.out.println("Area: " + r.calculateArea());
        r.displayColor();

    }
}