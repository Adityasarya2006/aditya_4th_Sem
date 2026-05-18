package Day7;

public class Step2_MultipleCatch {
    public static void main(String[] args) {

        @SuppressWarnings("unused")
        String[] names = {"Alice", "Bob"};
        @SuppressWarnings("unused")
        String emptyName = null; 
        
        System.out.println("🛡️ [SYSTEM]: Entering the danger zone...");
        
        try {

            int testScore = Integer.parseInt("abc");
            System.out.println("Score is: " + testScore);
            
        } 

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("🚨 [ERROR]: Array Index issue! You tried to access a slot that doesn't exist.");
        } 

        catch (NullPointerException e) {
            System.out.println("🚨 [ERROR]: Null Pointer! You tried to use an object that hasn't been initialized.");
        } 

        catch (NumberFormatException e) {
            System.out.println("🚨 [ERROR]: Number Format! You tried to convert text into a number.");
        } 

        catch (Exception e) {
            System.out.println("🚨 [GENERAL ERROR]: Something else went wrong: " + e.getMessage());
        }
        
        System.out.println("✅ [SYSTEM]: Danger zone passed securely.");
    }
}