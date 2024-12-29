package learn.java8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class FunctionalProgrammingExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Using External Iterator
        System.out.println("Traditional External Iterator");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i);
        }

        //Using External Iterator - for Each
        System.out.println("Traditional External Iterator - - for Each");
        for (int ele : numbers) {
            System.out.println(ele);
        }

        //Using Internal Iterator - Polymorphism -> To hide the implementation detail on how iteration happens
        System.out.println("Internal Iterator - Polymorphism - anonymous innerclass");
        //Consumer is an interface with single abstract method - so writing anonymous innerclass to print value of each element
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //Using Internal Iterator - Polymorphism -> To hide the implementation detail on how iteration happens
        //Replacing Inner Class with Lambda - since its single abstract method
        System.out.println("Internal Iterator - Polymorphism - Lambda Expression");
        numbers.forEach((Integer integer) -> {
            System.out.println(integer);
        });
        //Here we are iterating a collection of Integers (Bcoz of numbers is a List Collection of Integer.
        // So no need to specify Integer Data Type here again within parameter.
        // SO Type Inference -> only in Lambda expression
        System.out.println("Internal Iterator - Polymorphism - Lambda Expression - Type Inference");
        numbers.forEach((integer) -> System.out.println(integer));
        //In abovve -> Intger is being passed to System out object to access Println .. There is no change happening on the variable value/
        // In that scenario, method reference can be utilized.
        System.out.println("Internal Iterator - Method Reference");
        numbers.forEach(System.out::println);
        System.out.println("Stream Examples");
        //Stream is not a physical object.It doesn't store any values
        // Its not like Array, List or Set.
        //Its a functional compositions -> has pipeline of transformations.
        // Kind of pipeline.
        /**
         * Stream operations are 2 types -> Intermediate & Terminal Operations.
         * Intermediate Opns -> Filter, Map  (intermediate operations may not be mandatory as well , 0 or more occurrences)
         *  - Intermediate Opns are Lazy. They just create a new stream with elements that matches the predicate conidition/
         *  - Traversal of the pipeline doesn't happen until the terminal operation is executed.
         *  - Once traversal is completed, stream is no longer used. It doesn't hold anything.
         *  - Lazy pipeline processing -> helps to improve efficiencies
         *  - mainly in case of filter-map-sum -> where the processing of data can happen in a single pass without any intermediate state.
         *  - Also, for few opns like findFirst -> it need not traverse through all the data.
         *
         *Also there are 2 types
         * Stateful -> distinct, sorted
         * Stateless -> filter, map -> no need to worry other element. it cna be processed in parallel
         *
         *
         * Terminal Opns -> .forEach or Reduce or sum.
         *  Reduction Operations
         *  - Can run across a swimlane.
         *  - can combine all data elements into a single value, or (create a new list) or (max of numbers)
         *   -  reduce or collect
         *   Specialized form of reductions
         *   - count, max, sum
         *
         *  Associativity -> function is considered as Associate - if below holds good
         *  (a op b ) op c  == a op (b op c)
         *  For Parallelism
         *  a op b op c op d == (a op c) op (b op d)
         *  operation  (op) can be numeric addition, max, min,string concatentation
         **/
        int sum = 0;
        for (int e : numbers) {
            sum += e;
        }
        // Above is mutative addition.. More effective way is to use stream reduction.
        // Bcoz reduction function operates on the stream (which is more efficient) compared to individual elements
        //As long as the operation or individual elements are associative & stateless -> reduction function can be executed in parallel.
        //reduce -> is a terminal operation
        sum = numbers.stream()
                //.reduce(IdentityValue, BinaryOperator Accumulator)
                .reduce(0, (x, y) -> x + y); // Identity value will be 0 for addition, 1 for multiplication,
        //x refers to current value of accumulated sum. Y represents the element of the stream.
        // Operation (x + y) keeps executing until the finish all stream elements.
        //BinaryOperator -> 2 inputs of same type and resulting output is also of same type
        //Above can be replaced with Method Reference
        sum = numbers.stream()
                //.reduce(IdentityValue, BinaryOperator Accumulator)
                .reduce(0, Integer::sum);
        //filter function -> o/p of filter function is either 0, all values or partial set of values
        // Its based on predicate condition.

        //map function -> no of i/p values will be equal to the no of o/p values/
        //-> But the data type can change.

        System.out.println(numbers.stream()
                .filter(e -> e % 2 == 0) //Filter out even numbers
                .map(e -> e * 2.0) // Convert it to float value.
                .count());

        // Inorder to concatenate stream elements as String
        String sumAsString = numbers.stream()
                //.map(e -> String.valueOf(e)) // Here we are converting it to String.Since its static method of String. we can leverage method reference
                .map(String::valueOf)
                //.reduce("",(concatenatedValue,e) -> concatenatedValue.concat(e)); // can be replaced with below
                .reduce("", String::concat);
        System.out.println(sumAsString);

        /**
         * Collect -> is a mutable reduction operation, its uses Collector.
         */
        // Filter even numbers, multiple by 2 and add it to the list
        List<Integer> updateList = new ArrayList<>();
        updateList = numbers.stream()
                .filter(e -> e % 2 == 0) // To filter only even numbers
                .map(e -> e * 2) // WIth FIltered values, double it
                //        .forEach(e -> updateList.add(e)); // This is incorrect - Shared Mutability is wrong, it will lead to concurrency problem
                .collect(Collectors.toList());
        System.out.println(updateList);
        // Going through ToMap, groupingBy, MappingBy methods
        List<Person> groupOfppl = StreamsConceptExample.createPeople();
        Map<String, Person> pplMap = groupOfppl.stream()
                .collect(Collectors.toMap(person -> person.getName() + "-" + person.getAge(), person -> person)); // Traversing through stream, mapping to to key Value pairs/
        System.out.println(pplMap);
        //{Arun-27=learn.java8.functional.Person@300ffa5d, Sara-24=learn.java8.functional.Person@1f17ae12, Sara-22=learn.java8.functional.Person@4d405ef7}

        //So now, instead of toMap let us use -> groupingBy function
        //Returns a Collector ->implementing groupBy operation based on input type and return a Map object,
        //For groupingBy -> parameter is a classifier (classifier function mapping input elements to key)
        System.out.println(groupOfppl.stream()
                .collect(groupingBy(Person::getName))); // To print Map object, will all names
       // {Arun=[learn.java8.functional.Person@300ffa5d], Sara=[learn.java8.functional.Person@4d405ef7, learn.java8.functional.Person@1f17ae12]}
        //So instead of keeping Person object as value, can we retrieve and maintain actual object attributes as Value (within Map)
        System.out.println(groupOfppl.stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge,toList()))));
        //{Arun=[27], Sara=[22, 24]}

        //Bounded Stream Example
        // Both Imperative Style vs Bounded Stream Style
        //Problem
        // Given a number K, and count n, find the total of double of n
        //even numbers starting with k, where sqrt of each number is > 20
        int k = 1000;
        int intValue = k;
        int n = 6;
        double probSum = 0;
        while( n > 0)
        {
            double sqrtValue = Math.sqrt(intValue);
            if(intValue % 2 == 0 && sqrtValue > 20)
            {
                    probSum += intValue * 2;
                    n--;
            }
            intValue++;
        }
        System.out.println(probSum);
        k = 1000;
        n = 6;
        //Using Streams
        probSum =  Stream.iterate(k,e -> e + 1) // Start the iteration
                .filter(e -> e % 2 == 0) // Intermediate
                .filter(e -> Math.sqrt(e) > 20) // Intermediate
                .mapToInt(e -> e * 2) //Intermediate
                .limit(n) //Intermediate
                .sum(); // Sum expects Integer value, so we used mapToInt method -> so that float is converted to Int
        System.out.println(probSum);
    }
}
