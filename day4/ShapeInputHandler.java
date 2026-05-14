package day4;

class Shape {

    void calculateArea(int side) {
        int area = side * side;
        System.out.println("Area of Square = " + area);
    }

    void calculateArea(int length, int width) {
        int area = length * width;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class ShapeInputHandler {
    public static void main(String[] args) {

        Shape shape = new Shape();

        shape.calculateArea(5);

        shape.calculateArea(6, 4);
    }
}