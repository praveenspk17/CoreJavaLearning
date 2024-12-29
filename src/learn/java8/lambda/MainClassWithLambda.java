package learn.java8.lambda;

public class MainClassWithLambda {

    public static void main(String[] args) {
       //  example = new AgeInterface {
         //   () -> System.out.println("Hello World");
        AgeInterface example = () -> System.out.println("Hello World using Lambda");
    }
}
