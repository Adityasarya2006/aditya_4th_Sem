package Day7;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ⚡ TOPIC 4 - STEP 2: READING FROM A FILE
 * 🚀 RUN ORDER: [TOPIC 4 - B] - RUN THIS AFTER STEP 1.
 * 🎯 GOAL: Learn how to read text from a file line-by-line efficiently.
 */
public class Step2_ReadFile {
    public static void main(String[] args) {
        
        System.out.println("📖 [READING]: Accessing storage...");
        
        // 🔮 Try-With-Resources to automatically close the file when done.
        try (
            FileReader fr = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(fr) // Buffer grabs big chunks of the file at once
        ) {
            
            String line;
            int lineNumber = 1;
            
            // 🔄 br.readLine() reads an entire line of text.
            // When it reaches the very end of the file (EOF), it returns 'null'.
            // So we loop until the line becomes null!
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            
            System.out.println("✅ [SUCCESS]: Read complete!");
            
        } catch (FileNotFoundException e) {
            System.out.println("🚨 [ERROR]: File not found! Did you run Step 1 to create it first?");
        } catch (IOException e) {
            System.out.println("🚨 [ERROR]: Hard drive read error! " + e.getMessage());
        }
    }
}