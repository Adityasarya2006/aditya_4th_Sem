package Day7;

/**
 * 🎓 TOPIC 3 TASK: THE AGE RESTRICTOR
 * 
 * 👨‍🎓 STUDENT INSTRUCTIONS:
 * 1. Create a custom exception class named 'InvalidAgeException'.
 * 2. Create a method 'checkAge(int age)' that throws InvalidAgeException if age is less than 18.
 * 3. In the main method, test it with ages 20 and 15 inside a try-catch block.
 */

// 1️⃣ Custom Exception
@SuppressWarnings("serial")
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Topic3_Task_Solution {
    
    // 2️⃣ Business Logic Method
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is restricted! Must be 18 or older.");
        }
        System.out.println("✅ Access Granted for age: " + age);
    }

    public static void main(String[] args) {
        System.out.println("🎟️ Welcome to the Movie Theater!");
        
        int[] agesToTest = {20, 15};
        
        // 3️⃣ Testing the logic
        for (int age : agesToTest) {
            try {
                checkAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("🚨 DENIED: " + e.getMessage());
            }
        }
    }
}