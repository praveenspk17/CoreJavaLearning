package learn.concepts;

public class LambdaConcept {
    /**
     * Wherever there is an interface with single abstract method (Eg: Runnable, Callable, ActionListener etc->
     *     we can readily use Lambda instead of Anonymous inner class
     *
     *     Adv of Lambda (From Compiler Perspective)
     *             -> It doesn't generate additional inner class (.class) file for each Lambda expression.
     *             Reduces the no of classes (footprint) - when there are more no of anonymous inner classes.
     *
     *     Lambda -> Keeps only 2 & 3
     *     Function has 4 things
     *             1. name (Anonymous inner class -> doesnt have any name)
     *             2. parameters - needed
     *             3. body list - needed
     *             4. return Type  - can be inferred
     *
     *             Lambda should be kept Short - Kind of Glue Code (2 lines may be too many - Venkat Subramaniam)
     * - Not good design to keep logic in Lambda
     * - Logic should be moved to function, have it unit tested, call function via Lambda
     *
     */


}
