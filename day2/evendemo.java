package day2;

public class evendemo {
    public static void main(String[] args) {

        for (int i = 2; i <= 50; i += 2) {

            if (i % 15 == 0) {
                System.out.println(i + " FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.println(i + " Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}