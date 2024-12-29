package learn.java8.lambda;

import java.security.spec.RSAOtherPrimeInfo;

public class MainClassWithInnerClass {
    public static void main(String[] args) {
        //Here instead of instantiating of mainClassWithInnerClass and then calling ExampleClass.
        // Directly writing implementation for displayHelloWorld here as part of Inner Class

        AgeInterface example = new ExampleClassImplementsInterface() {
            @Override
            public void displayHelloWorld() {
                System.out.println("Hello World from Inner Class");
            }
        };
        example.displayHelloWorld();

    }
}
