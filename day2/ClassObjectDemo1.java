package day2;

class Student {

    String name;
    int age;
    String course;

    void showStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

class Teacher {

    String name;
    String subject;
    int experience;

    // Method
    void showTeacherInfo() {
        System.out.println("Teacher Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Experience: " + experience + " years");
    }
}

public class ClassObjectDemo1 {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "Aditya";
        student1.age = 21;
        student1.course = "AIML";

        Teacher teacher1 = new Teacher();
        teacher1.name = "Amith";
        teacher1.subject = "Java Programming";
        teacher1.experience = 10;

        student1.showStudentInfo();

        System.out.println("--------------------------");

        teacher1.showTeacherInfo();
    }
}