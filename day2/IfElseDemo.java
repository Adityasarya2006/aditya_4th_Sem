package day2;

public class IfElseDemo {

   
    public static void main(String[] args) {

        String signal = "GREEN";

   
        if (signal.equals("GREEN")) {
            System.out.println("Go! Road is clear.");
        }
        
        else if (signal.equals("YELLOW")) {
            System.out.println("Slow down! Signal is changing.");
        }
     
        else {
            System.out.println("STOP! Red signal.");
        }

        System.out.println("--------------------------------");


        int marks = 75;  

        if (marks >= 90) {
            System.out.println("Grade: A  — Excellent!");
        } else if (marks >= 75) {
            System.out.println("Grade: B  — Good work!");
        } else if (marks >= 60) {
            System.out.println("Grade: C  — Keep improving.");
        } else {
            System.out.println("Grade: F  — Need to study more.");
        }
    }
}