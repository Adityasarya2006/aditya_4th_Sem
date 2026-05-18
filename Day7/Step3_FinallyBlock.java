package Day7;

import java.io.FileReader;
import java.io.IOException;

/**
 * 🛒 TOPIC 1 - STEP 3: THE UNSTOPPABLE FINALLY BLOCK
 * 🚀 RUN ORDER: [TOPIC 1 - C] - RUN THIS LAST IN TOPIC 1.
 * 🎯 GOAL: Learn how the 'finally' block ensures resource cleanup.
 */
public class Step3_FinallyBlock {
    public static void main(String[] args) {
        
        System.out.println("🚦 [SYSTEM]: Starting operation...");
        FileReader reader = null; // Declare reader outside so finally can see it
        
        try {
            System.out.println("📖 [ACTION]: Trying to open an imaginary file...");
            // We are trying to read a file that doesn't exist to force an error
            reader = new FileReader("ghost_file.txt"); 
            System.out.println("This line won't execute because the file is missing.");
            
        } catch (IOException e) {
            System.out.println("🛡️ [CATCH]: Caught an IOException! File was not found.");
            
        } finally {
            // 🧹 THIS BLOCK ALWAYS RUNS! Whether the try succeeds or the catch catches.
            // It is the ultimate "cleanup crew" for closing network connections and files.
            System.out.println("🧹 [FINALLY]: This block always runs! Cleaning up resources...");
            
            if (reader != null) {
                try {
                    reader.close(); // Close the file if it was actually opened
                    System.out.println("🔒 [FINALLY]: File closed successfully.");
                } catch (IOException e) {
                    System.out.println("🚨 [FINALLY]: Could not close file.");
                }
            } else {
                System.out.println("🔒 [FINALLY]: No file was open, nothing to close.");
            }
        }
        
        System.out.println("✅ [SYSTEM]: Operation complete.");
    }
}