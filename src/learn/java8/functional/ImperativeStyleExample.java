package learn.java8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ImperativeStyleExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        //External Iterator
//        for(int i = 0; i < numbers.size(); i++)
//        {
//            System.out.println(numbers.get(i));
//        }
//        //External Iterator
//        for(int e : numbers)
//            System.out.println(e);
        //Internal Iterators - Polymorphism ->Hiding the implementation of how it iterates
//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer value) {
//                System.out.println(value);
//            }
//        });

        //Internal iterator using Lambda
//        numbers.forEach((Integer value)
//            -> System.out.println(value));
        //In above, We are iterating Collection of Integers, so why we need to
        // specify again the Integer as paramter type
        // This is called Type Interface (Java 8) but only for Lambda Expression
//        numbers.forEach((value) -> System.out.println(value));
//        //Below stmt is also valid. If Lambda has one parameter, paranthesis is optional
//        numbers.forEach(value -> System.out.println(value));
        // In the above, its a simple pass-through of argument to System.out Object of Println method.
        //No manipulation is happening -
        numbers.forEach(System.out::println); // Called As Method Reference -> Lambda is replaced with Method Ref
    }
}
