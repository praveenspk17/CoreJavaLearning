package learn.java8.lambda;

public class ExampleUsingInterfaceWithoutLamda {

    public static void main(String[] args)
    {
        AgeInterface ageInterface = new AgeInterface() {
            @Override
            public void displayHelloWorld() {
                System.out.println("Hello from Example");
            }
        };
        ageInterface.displayHelloWorld();
    }
}
