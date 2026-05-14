package day4;

class Animal {
    void type() {
        System.out.println("This is an animal.");
    }
}

class Lion extends Animal {
    @Override
    void type() {
        System.out.println("Lion is a wild animal.");
    }
}

class Elephant extends Animal {
    @Override
    void type() {
        System.out.println("Elephant is a large animal.");
    }
}

class Dog extends Animal {
    @Override
    void type() {
        System.out.println("Dog is a domestic animal.");
    }
}

class Tiger extends Animal {
    @Override
    void type() {
        System.out.println("Tiger is a strong wild animal.");
    }
}

class Bird extends Animal {
    @Override
    void type() {
        System.out.println("This is a bird.");
    }
}

// Bird Types
class Peacock extends Bird {
    @Override
    void type() {
        System.out.println("Peacock is a colorful bird.");
    }
}

class Parrot extends Bird {
    @Override
    void type() {
        System.out.println("Parrot can mimic sounds.");
    }
}

class Eagle extends Bird {
    @Override
    void type() {
        System.out.println("Eagle is a powerful bird.");
    }
}

public class AnimalBirdDemo {

    public static void main(String[] args) {

      
        Animal a1 = new Lion();
        Animal a2 = new Elephant();
        Animal a3 = new Dog();
        Animal a4 = new Tiger();

  
        Bird b1 = new Peacock();
        Bird b2 = new Parrot();
        Bird b3 = new Eagle();

        a1.type();
        a2.type();
        a3.type();
        a4.type();

        b1.type();
        b2.type();
        b3.type();
    }
}