package day2;

public class LoopsDemo {
    public static void main(String[] args) {


        System.out.println("--- FOR LOOP: 1 to 5 ---");
        for (int i = 1; i <= 5; i++) {
           
            System.out.println("i = " + i);
        }

        System.out.println("\n--- WHILE LOOP: Countdown ---");
        int count = 5;
        while (count > 0) {

            System.out.println("Count: " + count);
            count--;  
        }
        System.out.println("Blast off!");

        System.out.println("\n--- DO-WHILE: Runs at least once ---");
        int x = 10;
        do {
           
            System.out.println("x = " + x);
            x++;
        } while (x < 5); 
    }
}
