package day2;

class Student {
    String name;
    String usn;
    int marks;

    void submarks() {
        System.out.println(name + " scored: " + marks + " marks.");

        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 80) {
            System.out.println("Grade: B");
        } else if (marks >= 70) {
            System.out.println("Grade: C");
        } else if (marks >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    void details() {   // corrected spelling
        System.out.println("\n------------------------");
        System.out.println("    Student Details ");
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("Marks: " + marks);
    }
}

public class DStudent {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.name = "Dhanush";
        s1.usn = "4CE19CS001";
        s1.marks = 85;

        Student s2 = new Student();
        s2.name = "Arjun";
        s2.usn = "4CE19CS002";
        s2.marks = 92;

        s1.submarks();
        s1.details();

        s2.submarks();
        s2.details();
    }
}