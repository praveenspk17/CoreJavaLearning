package learn.java8.functional;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Using Internal Iterator - with Inner Class
        System.out.println("Data Output - Internal Iterator");
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("Data Output - Replacing Internal Iteration with Lambda");
        numbers.forEach((Integer integer) -> { // Parenthesis are optional for single line.
                System.out.println(integer);
            }
        );
        /**
         * Types of Method Reference
         * 1. Static Method Reference
         */
        numbers.stream()
                .map(String::valueOf) // valueOf is the Static Method of String Class
                .count();
        //Replacing Lambda With Method Reference -> As it just a pass Through
        // 2. Instance method of an object
        // Argument is passed to an instance Method -> println is an instance method of Printstream class.
        //System.out is an instance object.
        numbers.forEach(System.out::println);
        //Another Example to pass paramter to static method
        numbers.stream()
                      //  .map( e -> String.valueOf(e))// Static Method
                        .map(String::valueOf)
                        .forEach(System.out::println);
        // Parameter is becoming a target  - Method Reference
        //3. Instance method of an Arbitrary Object of a Type
        //Its like - for any instance of this class, call this method
        //This method is called on each element of the stream
        numbers.stream()
                //.map(e -> e.toString())// Invoking toString function on the target
               // .map(e -> String.valueOf(e))
                .map(String::valueOf)// To a Static Method - parameter is being passed
                .map(String::toString) // Invoking toString function on the target (3rd Type)
                .forEach(System.out::println);
        //4. Constructor Reference ClassName:: new
        // Its used to create new objects
        //Supplier<List<String>> listSupplier = () -> new ArrayList<>(); // Using a lambda expression
       // Supplier<List<String>> listSupplierRef = ArrayList::new;       // Using a constructor reference

    //    List<String> myList = listSupplierRef.get(); // Creates a new ArrayList

        Stream<String> stream = Stream.of("one", "two", "three");
        List<String> output = stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(output);
// Collect elements into a new ArrayList
        stream = Stream.of("one", "two", "three");  // Once Stream is processed by terminal operation, it will not have any value.
        List<String> result = stream.collect(Collectors.toList());
        System.out.println(result); // Both this and above performs same behavior


        //Another Example --->
        // Here we try to pass 2 arguments as parameter for method reference
        System.out.println(
        numbers.stream()
               // .reduce(0,(total,e) -> Integer.sum(total, e)); // Reduce Function has 2 parameters
        //First Parameter 0 is initial value
        // 2nd paramter is Lambda function with 2 paramter (order is important)
                .reduce(0,Integer::sum));
        //ANother example - where out of 2 parameters, one is becoming a target,
        // another has an argument
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                 //       .reduce("",(initial,str) -> initial.concat(str)));
                        .reduce("",String::concat));

        //Limitation of Method Reference
        //1. Should not use when there is manipulation or any logic
        //2. If there is ambiguty in using Instance or Static Method for a class.
        // Suppose if both exists, it would error. Eg: Integer has toString -> (its both static vs Instance)


    }
}
