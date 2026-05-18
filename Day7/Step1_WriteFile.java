package Day7;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * ⚡ TOPIC 4 - STEP 1: WRITING TO A FILE
 * 🚀 RUN ORDER: [TOPIC 4 - A] - RUN THIS FIRST IN TOPIC 4.
 * 🎯 GOAL: Learn how to persist data to the hard drive using BufferedWriter.
 */
public class Step1_WriteFile {
    public static void main(String[] args) {
        
        System.out.println("💾 [ACTION]: Writing logs to physical storage...");
        
        // 📍 We will create a new file called 'output.txt'
        // The 'true' parameter means APPEND MODE (it adds to the end instead of wiping the file)
        try (
            FileWriter fw = new FileWriter("output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw) // Buffer makes writing 100x faster!
        ) {
            
            // Write a line of text to the RAM buffer
            bw.write("[LOG]: System initialized.");
            
            // Move to the next line (works securely on both Windows and Mac)
            bw.newLine();
            
            // Write another line
            bw.write("[LOG]: Day 7 Training in progress.");
            bw.newLine();
            
            // Since we use Try-With-Resources, Java will automatically 'flush' the buffer 
            // (dumping RAM to Hard Drive) and close the file when this block ends.
            
            System.out.println("✅ [SUCCESS]: Data written to 'output.txt' successfully.");
            
        } catch (IOException e) {
            System.out.println("🚨 [ERROR]: Could not write to file! " + e.getMessage());
        }
    }
}