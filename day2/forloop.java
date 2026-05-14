package day2;

public class forloop{
    public static void main(String[] args) {
        

        String[] names = {"Amith", "Shridhu","Adi", "Jeevan", "Dhanu"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name.contains("A")) {
                System.out.println("Name with A: " + name);
            }
        }
    }
}