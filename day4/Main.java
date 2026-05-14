package day4;


class Animal {
    void speak() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {

    @Override
    void speak() {
        System.out.println("Cat meows: Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.speak();
    }
}
