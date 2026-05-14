package day4;

public class CalculatorDemo {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + " + " + b + " = combined!";
    }

    public static void main(String[] args) {
       
        CalculatorDemo calc = new CalculatorDemo();

        System.out.println("Sum of 5 and 3: " + calc.add(5, 3));           

        System.out.println("Sum of 2, 3, and 4: " + calc.add(2, 3, 4));    

        System.out.println("Sum of 1.5 and 2.5: " + calc.add(1.5, 2.5));   

        System.out.println("Combined Strings: " + calc.add("Java", "Rocks")); 

    }
}