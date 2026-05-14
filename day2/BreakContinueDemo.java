package day2;


public class BreakContinueDemo {
    public static void main(String[] args) {

        System.out.println("--- BREAK Example ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; 
            }
            System.out.println("i = " + i); 
        }

        System.out.println("\n--- CONTINUE Example: Skip even numbers ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  
            }
            System.out.println("Odd: " + i); 

        System.out.println("\n--- Nested Loop Pattern ---");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
}