package day2;

public class SwitchDemo {
    public static void main(String[] args) {

        int day = 3; 

        switch (day) {
            case 1:
                System.out.println("Monday — Week starts!");
   
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday — Middle of the week!");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday — Almost weekend!");
                break;
            case 6:
            case 7:

                System.out.println("Weekend! No coding... just kidding.");
                break;

            default:
                System.out.println("Invalid day number.");
        }
    }
}