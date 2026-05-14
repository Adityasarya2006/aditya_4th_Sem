package day2;

class Dog {

    String name;   
    String breed;   
    int age;      

    void bark() {
        System.out.println(name + " says: Woof! Woof!");
    }

    void showInfo() {

        System.out.println("Name: " + this.name + ", Breed: " + this.breed + ", Age: " + this.age);
    }
}

public class ClassObjectDemo {
    public static void main(String[] args) {

        Dog dog1 = new Dog();
        dog1.name  = "Bruno";
        dog1.breed = "Labrador";
        dog1.age   = 3;

        Dog dog2 = new Dog();           
        dog2.name  = "Max";
        dog2.breed = "German Shepherd";
        dog2.age   = 5;

        dog1.bark();     
        dog2.showInfo();  
    }
}
