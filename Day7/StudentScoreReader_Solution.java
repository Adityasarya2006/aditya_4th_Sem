package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 🏆 TOPIC 5 - CAPSTONE PROJECT: INTEGRATED SYSTEM ARCHITECTURE
 * 🚀 RUN ORDER: [GRAND FINALE] - RUN THIS LAST.
 * 🎯 GOAL: Build a production-grade ETL (Extract, Transform, Load) CSV parser.
 * It integrates: File I/O + Try-With-Resources + Multiple Catch + Custom Exceptions.
 */

// ============================================================
// 💎 CUSTOM EXCEPTION: Business Logic Rule Enforcer
// ============================================================
@SuppressWarnings("serial")
class CapstoneInvalidScoreException extends Exception {
    public CapstoneInvalidScoreException(String message) {
        super(message);
    }
}

// ============================================================
// 🚀 MAIN APPLICATION: Secure Data Ingestion Portal
// ============================================================
public class StudentScoreReader_Solution {

    // 🛡️ Business Logic Validator
    public static void validateScore(String name, int score) throws CapstoneInvalidScoreException {
        if (score < 0 || score > 100) {
            throw new CapstoneInvalidScoreException(
                "🚨 [ERROR - OUT OF RANGE]: " + name + " has score " + score + " (must be 0-100)"
            );
        }
    }

    public static void main(String[] args) {
        
        // 📍 Pointing to the CSV file generated in Topic 0
        String filePath = "students.csv";
        
        // 📊 Analytics trackers
        int validCount = 0;
        int invalidCount = 0;

        System.out.println("============================================");
        System.out.println("       🏫 STUDENT CSV INGESTION PORTAL      ");
        System.out.println("============================================");

        // 🔮 Try-With-Resources for automatic memory safety
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isFirstLine = true;

            // 🔄 Loop through the file line-by-line
            while ((line = br.readLine()) != null) {

                // ⏭️ Skip the CSV Header line ("Name,Score,Grade")
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; 
                }

                // ✂️ Parse the CSV comma separation: [Alice] [92] [A]
                String[] parts = line.split(",");

                // 🛡️ Guard Clause: Protect against corrupted row structures
                if (parts.length != 3) {
                    System.out.println("⚠️ [SKIP]: Malformed line found: " + line);
                    invalidCount++;
                    continue;
                }

                // 🧹 Clean the data (remove extra spaces)
                String name = parts[0].trim();
                String scoreStr = parts[1].trim();
                String grade = parts[2].trim();

                // 🧠 The Inner Try-Catch for Data Parsing!
                try {
                    // Attempt to convert string "92" into integer 92.
                    // This might throw a NumberFormatException if the text says "INVALID"
                    int score = Integer.parseInt(scoreStr);

                    // Apply business logic rules (might throw CapstoneInvalidScoreException)
                    validateScore(name, score);

                    // If we survive the above checks without crashing into the catch block:
                    System.out.println("✅ [OK]:  " + name + " | Score: " + score + " | Grade: " + grade);
                    validCount++;

                } 
                // 🧯 Catch 1: Catching corrupted text-to-number failures
                catch (NumberFormatException e) {
                    System.out.println("🚨 [ERROR - CORRUPT DATA]: " + name + " has non-numeric score: '" + scoreStr + "'");
                    invalidCount++;
                } 
                // 🧯 Catch 2: Catching out-of-bounds custom logic failures
                catch (CapstoneInvalidScoreException e) {
                    System.out.println(e.getMessage());
                    invalidCount++;
                }
            }

        } 
        // 🧯 Catch 3: File does not exist
        catch (FileNotFoundException e) {
            System.out.println("🚨 [FATAL ERROR]: File '" + filePath + "' not found! Run Topic 0 Setup first.");
            return; // Kill the program immediately
        } 
        // 🧯 Catch 4: Hard drive exploded or permission denied
        catch (IOException e) {
            System.out.println("🚨 [FATAL ERROR]: Disk I/O read failure! " + e.getMessage());
            return;
        }

        // ============================================================
        // 📊 FINAL DASHBOARD ANALYTICS
        // ============================================================
        int totalProcessed = validCount + invalidCount;
        double successRate = (totalProcessed == 0) ? 0 : ((double) validCount / totalProcessed) * 100;

        System.out.println("\n--------------------------------------------");
        System.out.println("📊 INGESTION SUMMARY REPORT");
        System.out.println("--------------------------------------------");
        System.out.println("✅ Valid Records Ingested   : " + validCount);
        System.out.println("❌ Corrupted/Skipped Records: " + invalidCount);
        System.out.printf("📈 Ingestion Success Rate   : %.2f%%\n", successRate);
        System.out.println("============================================");
    }
}