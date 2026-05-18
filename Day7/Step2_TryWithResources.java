package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 🛡️ TOPIC 2 - STEP 2: TRY-WITH-RESOURCES (THE AUTO-CLEANER)
 * 🚀 RUN ORDER: [TOPIC 2 - B] - RUN THIS AFTER STEP 1.
 * 🎯 GOAL: Learn how Java 7+ automatically closes files so we don't need a finally block.
 */
public class Step2_TryWithResources {
    public static void main(String[] args) {
        
        System.out.println("📖 [ACTION]: Reading 'students.csv' securely...");
        
        // 🔮 NEW WAY: Try-With-Resources (Java 7+)
        // We declare the FileReader and BufferedReader INSIDE the parentheses ().
        // Because they implement 'AutoCloseable', Java promises to close them automatically
        // the exact moment this block finishes (whether it succeeds or crashes!).
        try (
            FileReader fr = new FileReader("students.csv");
            BufferedReader br = new BufferedReader(fr)
        ) {
            // Read the first two lines to prove it works
            String line1 = br.readLine();
            String line2 = br.readLine();
            
            System.out.println("   [LINE 1]: " + line1);
            System.out.println("   [LINE 2]: " + line2);
            
            // Notice there is no "br.close()" or "fr.close()" here.
            // Notice there is no "finally" block at the bottom.
            // Java does it for us!
            
        } catch (FileNotFoundException e) {
            System.out.println("🚨 [ERROR]: File 'students.csv' was not found!");
        } catch (IOException e) {
            System.out.println("🚨 [ERROR]: Could not read the file correctly. " + e.getMessage());
        }
        
        System.out.println("✅ [SUCCESS]: File closed automatically by Java!");
    }
}