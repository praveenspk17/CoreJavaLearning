package learn.concepts;

abstract class Animal {
    // Constructor invocation -> when a child class is instantiated
    public Animal()
    {
        System.out.println("Constructor invocation");
    }
    // Abstract method (no implementation)
    abstract void makeSound();

    static void toTryOut()
    {
        System.out.println("To tryout Static methods");
    }
    // Concrete method (with implementation)
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    // Providing implementation of the abstract method
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    // Providing implementation of the abstract method
    void makeSound() {
        System.out.println("Meow");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        //Invocation of Abstract class Static method
        Animal.toTryOut();
        dog.makeSound(); // Output: Bark
        dog.eat();       // Output: This animal eats food.

        cat.makeSound(); // Output: Meow
        cat.eat();       // Output: This animal eats food.
    }
}

