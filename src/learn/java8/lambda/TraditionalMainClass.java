package learn.java8.lambda;

public class TraditionalMainClass {
    public static void main(String[] args) {
        AgeInterface example = new ExampleClassImplementsInterface();
        example.displayHelloWorld();
        //Traditional way of invoking class that implements interface
        //All variables are - final & static
        System.out.println("Variable Print: " + AgeInterface.x);
    }
}
