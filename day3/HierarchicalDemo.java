package day3;

class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void eat() {
        System.out.println(name + " 🍴 is eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println(getName() + " 🐕 says: Woof! Woof!");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println(getName() + " 🐈 says: Meow! Meow!");
    }
}

public class HierarchicalDemo {
    public static void main(String[] args) {
        System.out.println("--- 🐾 ANIMAL KINGDOM DEMO ---");

        Dog myDog = new Dog();
        myDog.setName("Buddy");
        myDog.eat();  
        myDog.bark(); 

        Cat myCat = new Cat();
        myCat.setName("Kitty");
        myCat.eat();  
        myCat.meow(); 
        
        System.out.println("\n💡 LESSON: Multiple children can inherit from one parent!");
    }
}