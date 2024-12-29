package learn.java8.functional;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static java.util.stream.Collectors.*;

public class StreamsConceptExample {
    /**
     * Streams are abstraction. They are diff from List, Set, Array.
     * Streams doesn't contain data. It is not physical object
     * It's a bunch of functions.
     * - Non-mutating pipeline (Functional Composition -> Pipeline of transformations)
     *  -> Should not perform shared mutability
     *
     *  Functions:
     *  Filter: O/p of filter operation is either 0 or all or any number in-between,
     *  Input: Stream<T> filter takes predicate </T>
     *
     *  Map: Transforming functions
     *  // number of o/p -> is equal number of i/p
     * // no guarantee on the type of o/p w.r.t to type of i/p
     * //parameter: Stream<T> map takes Function<T,R> to return Stream<R>
     *
     * Both Filter and Map -> stay in the Swimlanes...
     *
     * Reduce:
     * Cuts across Swimlanes .(Brings values together)
     * Take initial value (of 0.0) and perform operation with 1st element of list, continues performing operation with 2nd element of list
     *  Reduce on Stream<T> takes 2 parameter:
     *  1. First Parameter - initial value is of type T
     *  2. Second Parameter -Type BiFunction(R,T,R) (1st R represents i/p, T represents Input Type, 2nd R represents output type)
     *   produce result of R.
     *
     *   Specialist Reduce FUnctions;
     *   - Sum (can be used for DoubleStream) -> Reduces to single Value
     *   - Collect
     *     1. toList
     *     2. toSet (Removes duplicates)
     *     3. toMap (to Map of Values)
     *
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(
        numbers.stream()
                .filter(e -> e% 2 == 0)
                .map(e -> e *2.0)// I/p is Integer, Output is Double
                .reduce(0.0,(carry,e) -> carry + e));

        //utilizing Sum
//        System.out.println(
//                numbers.stream()
//                        .filter(e -> e% 2 == 0)
//                        .mapToDouble(e -> e *2.0)
//                        .sum());

       // collectFunctionExample();
        invokingMapFunctionExample();
    }
    public static void collectFunctionExample()
    {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
        //Double the even numbers and add it to new list
        List<Integer> doubleEven = new ArrayList<>();
//                   numbers.stream()
//                        .filter(e -> e% 2 == 0)
//                        .map(e -> e * 2)// I/p is Integer, Output is Double
//                        .forEach(e -> doubleEven.add(e));// Don't do this, incorrect way
       // System.out.println(doubleEven);
        //Mutability is okay, Sharing is okay, But Shared Mutability is not okay.
        //Main Issue
        //In case, its being executed as a Parallel Stream, multiple threads might try to update on the same object
        // There would be occurence of concurrency problem.
        //Better way is to use COllect

        doubleEven = numbers.stream()
                .filter(e -> e% 2 == 0)
                .map(e -> e * 2)// I/p is Integer, Output is Double
                .collect(toList()); //doubleEven is shared object outside, do not make changes within stream
        System.out.println(doubleEven);

    }

    public static void invokingMapFunctionExample()
    {
        List<Person> people = createPeople();
        // Create a Map with name & age as Key and Person as Value
        System.out.println(
                people.stream()
                        .collect(toMap(
                                person -> person.getName() + "-" + person.getAge(),
                                person -> person)));
        //{Arun-27=learn.java8.functional.Person@1e80bfe8, Sara-24=learn.java8.functional.Person@66a29884, Sara-22=learn.java8.functional.Person@4769b07b}
//GroupingBy -> Group Of Objects
        //Given a list, let us create a map with key as person name and value is all the 'Person Objects with that name
        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName)));
        //{Arun=[learn.java8.functional.Person@1e80bfe8], Sara=[learn.java8.functional.Person@4769b07b, learn.java8.functional.Person@66a29884]}
        ////Given a list, let us create a map with key as person name and value is all the ages of the person
        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName,
                                mapping(Person::getAge, toList())))); // {Arun=[27], Sara=[22, 24]}


    }

    public static List<Person> createPeople()
    {
        return Arrays.asList(
                new Person("Sara", Person.Gender.FEMALE, 22),
                new Person("Sara",Person.Gender.FEMALE,24),
                new Person("Arun", Person.Gender.MALE, 27));
    }



}
