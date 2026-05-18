package Day7;

import java.util.Scanner;

/**
 * 🎓 TOPIC 1 TASK: THE CALCULATOR SHIELD
 * 
 * 👨‍🎓 STUDENT INSTRUCTIONS:
 * 1. Create a Scanner to ask the user for a numerator and denominator.
 * 2. Try to divide them and print the result.
 * 3. Use multiple catch blocks to catch BOTH ArithmeticException (divide by zero) 
 *    and NumberFormatException (if they type a word instead of a number).
 * 4. Add a finally block that prints "Calculation attempt finished."
 */
public class Topic1_Task_Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🧮 Welcome to the Safe Calculator!");
        
        try {
            System.out.print("Enter the numerator (number): ");
            int num1 = Integer.parseInt(scanner.nextLine()); // Might throw NumberFormatException
            
            System.out.print("Enter the denominator (number): ");
            int num2 = Integer.parseInt(scanner.nextLine());
            
            // Might throw ArithmeticException
            int result = num1 / num2;
            System.out.println("✅ Result: " + result);
            
        } catch (NumberFormatException e) {
            System.out.println("🚨 ERROR: You must type a valid integer number, not letters!");
        } catch (ArithmeticException e) {
            System.out.println("🚨 ERROR: You cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("🚨 GENERAL ERROR: Something unexpected happened.");
        } finally {
            System.out.println("🧹 Calculation attempt finished. Scanner closing.");
            scanner.close();
        }
    }
}