package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * 🛡️ TOPIC 2 - STEP 1: CHECKED EXCEPTIONS & THROWS KEYWORD
 * 🚀 RUN ORDER: [TOPIC 2 - A] - RUN THIS FIRST IN TOPIC 2.
 * 🎯 GOAL: Understand compile-time checked exceptions and passing the buck with 'throws'.
 */
public class Step1_CheckedDemo {

    // 📣 The 'throws IOException' tells the Java Compiler:
    // "Warning! This method is dangerous and might fail with an IOException. 
    // I am not handling it here. Whoever calls me MUST handle it!"
    public static void readExternalFile(String filePath) throws IOException {
        System.out.println("   -> [METHOD]: Inside readExternalFile(). Opening " + filePath);
        
        // FileReader deals with external system files, which might not exist.
        // Therefore, Java FORCES us to handle IOException (it is a 'Checked' exception).
        FileReader fr = new FileReader(filePath); 
        BufferedReader br = new BufferedReader(fr);
        
        // Reading the first line of the file
        String firstLine = br.readLine();
        System.out.println("   -> [FILE CONTENT]: " + firstLine);
        
        // Cleaning up manually
        br.close(); 
        fr.close();
    }

    public static void main(String[] args) {
        System.out.println("🛡️ [MAIN]: Starting secure file read process...");
        
        // ⚠️ Because readExternalFile() declares 'throws IOException', 
        // the main method is FORCED to wrap it in a try-catch block!
        try {
            // We pass the path to the CSV we created in Topic 0
            readExternalFile("students.csv");
            System.out.println("✅ [MAIN]: File read successfully without crashing.");
            
        } catch (IOException e) {
            // If anything went wrong inside readExternalFile(), we catch it here.
            System.out.println("🚨 [MAIN ERROR]: Failed to read the file! " + e.getMessage());
        }
    }
}