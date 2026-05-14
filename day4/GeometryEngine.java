package day4;


public class GeometryEngine {

    public int calculateArea(int side) {
        return side * side;
    }

    public int calculateArea(int length, int width) {
        return length * width;
    }

    public double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }

    public float calculateArea(float base, float height) {
        return (base * height) / 2;
    }

    public void logShape(String name, int area) {
        System.out.println(name + ": " + area);
    }

    public void logShape(int area, String name) {
        System.out.println(area + ": " + name);
    }

    public static void main(String[] args) {

        GeometryEngine obj = new GeometryEngine();

        int squareArea = obj.calculateArea(5);
        System.out.println("Square Area: " + squareArea);

        int rectangleArea = obj.calculateArea(10, 5);
        System.out.println("Rectangle Area: " + rectangleArea);

        double circleArea = obj.calculateArea(4.5);
        System.out.println("Circle Area: " + circleArea);

        float triangleArea = obj.calculateArea(6.0f, 4.0f);
        System.out.println("Triangle Area: " + triangleArea);

        obj.logShape("Square", squareArea);
        obj.logShape(squareArea, "Square");
    }
}