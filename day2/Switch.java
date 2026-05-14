package day2;
public class Switch {
    public static void main(String[] args) {
       
        int channel = 2;

        switch (channel) {
            case 1:
                System.out.println("You are watching: National Geographic");
                break;
            case 2:
                System.out.println("You are watching: Discovery Channel");
                break;
            case 3:
                System.out.println("You are watching: History Channel");
                break;
            default:
                System.out.println("Channel not available.");
        }

    }
}