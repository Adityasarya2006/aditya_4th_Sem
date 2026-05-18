package Day7;

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Topic4_Task_Solution {
   public Topic4_Task_Solution() {
   }

   public static void main(String[] var0) {
      String var1 = "attendance.txt";
      System.out.println("\ud83d\udcdd Phase 1: Writing to the Attendance Register...");

      try {
         BufferedWriter var2 = new BufferedWriter(new FileWriter(var1));

         try {
            var2.write("John Doe - Present");
            var2.newLine();
            var2.write("Jane Smith - Present");
            System.out.println("✅ Writing complete!");
         } catch (Throwable var7) {
            try {
               var2.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }

            throw var7;
         }

         var2.close();
      } catch (IOException var8) {
         System.out.println("\ud83d\udea8 Failed to write to file: " + var8.getMessage());
      }

      System.out.println("\n\ud83d\udcd6 Phase 2: Reading the Attendance Register...");

      try {
         BufferedReader var11 = new BufferedReader(new FileReader(var1));

         try {
            String var3;
            while((var3 = var11.readLine()) != null) {
               System.out.println("   -> " + var3);
            }

            System.out.println("✅ Reading complete!");
         } catch (Throwable var9) {
            try {
               var11.close();
            } catch (Throwable var5) {
               var9.addSuppressed(var5);
            }

            throw var9;
         }

         var11.close();
      } catch (IOException var10) {
         System.out.println("\ud83d\udea8 Failed to read from file: " + var10.getMessage());
      }

   }
}