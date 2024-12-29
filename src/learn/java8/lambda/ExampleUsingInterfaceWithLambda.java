package learn.java8.lambda;

public class ExampleUsingInterfaceWithLambda {

    public static void main(String[] args) {

       /* AgeInterface ageInterface = new AgeInterface() {
            @Override
            public void displayHelloWorld() {

            }
        };*/

        //Since Lambda Exp are suitable for interface with single abstract method. //
        // We can remove instantiation part and single method's name.
        //Only parameter list and body of method is needed. If the body has single execution line, parenthesis is not reqd.
       // AgeInterface ageInterface = () -> {System.out.println("Hello Display");};
        //Another way
        AgeInterface ageInterfaceOther = () -> System.out.println("Hello Display");
        ageInterfaceOther.displayHelloWorld();

    }
}
