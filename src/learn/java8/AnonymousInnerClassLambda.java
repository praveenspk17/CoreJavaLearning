package learn.java8;

public class AnonymousInnerClassLambda {
    public static void main(String[] args) {
        /*
            Wherever there is an interface with single abstract method (Eg: Runnable, Callable, ActionListener etc->
            we can readily use Lambda instead of Anonymous inner class

            Adv of Lambda
            -> It doesn't generate additional inner class (.class) file for each anonymous inner class.

            Lambda -> Keeps only 2 & 3
            Function has 4 things
            1. name (Anonymous inner class -> doesnt have any name)
            2. parameters - needed
            3. body list - needed
            4. return Type  - can be inferred
         */
        // Thread constructor -Lambda Exp
        Thread th = new Thread(() -> System.out.println("In Another Thread"));
        th.start();
        System.out.println("In Main - Lambda");
    }
}
