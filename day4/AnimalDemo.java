package day4;

class Animal {

    public void speak() {
        System.out.println("Some animal makes a sound");
    }

    public void breathe() {
        System.out.println("Breathing with lungs");
    }
}

class Dog extends Animal {

    @Override
    public void speak() {
        System.out.println("Dog barks: Woof!");
    }
}

class Labrador extends Dog {

    @Override
    public void speak() {

        super.speak();

        System.out.println("Labrador barks louder: WOOF WOOF!");
    }
}

public class AnimalDemo {

    public static void main(String[] args) {

        System.out.println("--- Case 1: Simple Object ---");

        Animal a1 = new Animal();
        a1.speak();
        a1.breathe();

        System.out.println("\n--- Case 2: UPCASTING ---");

        Animal a2 = new Dog();

        a2.speak(); 
        a2.breathe();  

        System.out.println("\n--- Case 3: Grandchild Object ---");

        Animal a3 = new Labrador();

        a3.speak();  
        a3.breathe();
    }
}