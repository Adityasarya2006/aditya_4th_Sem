package Day7;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 🎓 TOPIC 2 TASK: THE GHOST FILE AUTO-CLEANER
 * 
 * 👨‍🎓 STUDENT INSTRUCTIONS:
 * 1. Write a Try-With-Resources block.
 * 2. Attempt to open a FileReader for a file called "top_secret.txt".
 * 3. Catch the FileNotFoundException explicitly and print "Access Denied: File missing."
 * 4. Verify that you don't need a finally block to close the reader!
 */
public class Topic2_Task_Solution {
    public static void main(String[] args) {
        System.out.println("🕵️ Attempting to access classified information...");
        
        // 🔮 Try-With-Resources automatically closes the FileReader when the block finishes
        try (FileReader fr = new FileReader("top_secret.txt")) {
            
            System.out.println("🔓 File opened! Reading secrets...");
            fr.read(); // Read a character to utilize the resource (fixes compiler warning)
            
        } catch (FileNotFoundException e) {
            System.out.println("🚨 [ACCESS DENIED]: The file 'top_secret.txt' does not exist on this server.");
        } catch (IOException e) {
            System.out.println("🚨 [ERROR]: An I/O error occurred.");
        }
        
        System.out.println("✅ Security protocol finished. System secured automatically.");
    }
}