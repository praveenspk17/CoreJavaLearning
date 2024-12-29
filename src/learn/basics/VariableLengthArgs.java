package learn.basics;

import java.util.Arrays;

public class VariableLengthArgs {

    public static void main(String[] args) {
        // Example for variable Length Arguments.
        // If you don't know the length of the arguments that you would pass, u can use it.
        // It would be considered as Arrays of those.

        fun(12, 40,"Praveen","Arun","Madhav");

    }
    // String ...v (Arrays of Strings) -> Always it should be last in the argument List
    static void fun(int a, int b, String ... v)
    {
        System.out.println(Arrays.asList(v));
        //O/p - [Praveen, Arun, Madhav]
    }
}
