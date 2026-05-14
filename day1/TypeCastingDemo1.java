public class TypeCastingDemo1 {

    public static void main(String[] args) {

        // ---- STRING CONCATENATION ----
        String firstName = "Aditya";
        String lastName  = "Arya";
        String city      = "Bengaluru";
        String email     = "aditya@example.com";

        // Phone number should be String (recommended)
        String phno = "7676543215";

        // + joins Strings — called CONCATENATION
        String fullName = firstName + " " + lastName;

        System.out.println("Full Name: " + fullName);
        System.out.println("City: " + city);
        System.out.println("Email: " + email);
        System.out.println("Phone No: " + phno);

        // ---- WIDENING CAST (Automatic) ----
        // int has less precision than double
        // Java automatically widens int into double
        int marks = 85;

        double marksDouble = marks; // automatic conversion

        System.out.println("Marks as double: " + marksDouble); // 85.0

        // ---- NARROWING CAST (Manual) ----
        // double has more precision than int
        // We must explicitly cast using (int)

        double cgpa = 7.95;

        int cgpaInt = (int) cgpa; // decimal part removed

        System.out.println("CGPA as int: " + cgpaInt); // prints 7

        // (int) truncates the decimal part
        // It does NOT round the number

    }
}