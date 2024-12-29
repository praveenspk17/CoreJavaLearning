package learn.java8.functional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPerformanceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        //Given an ordered list, find the double of first even number greater than 3 (number also greater than 3)
        // Imperative Style
        int result = 0;
        int finalValue = 0;
        for (int e : numbers)
        {
            if( e > 3 && e % 2 == 0)
            {
                result = e * 2;
                break;
            }
        }
        System.out.println("Result: " + result); // O/p : Result: 8
        // How much unit of work for above code execution -> 8 units of work

        //Functional Style
        System.out.println(
          numbers.stream()
                  .filter(StreamPerformanceExample :: isGT3)
                  .filter(StreamPerformanceExample :: isEven)
                  .map(StreamPerformanceExample::doubleIt)// Without last stmt, if i execute -> O/p -> java.util.stream.ReferencePipeline$3@34c45dca
                    .findFirst()); // Output : Optional[8] // This stmt triggers the computation.
    // Stream does a Lazy Evaluation:
        // 2 kinds of operations.
        // Intermediate Operations, Terminal Operations.
        // Intermediate Operations -> Just build the pipeline of functions doesn't perform the exeuction.
        // When Terminal Operation get invoked -> then the computation happens.
        //Also, during the iteration, 1st value goes through the entire pipeline
        // For Eg: 1 is not GT 3, 2 is not GT 3, 3 is not GT 3, 4 is GT 3, then it goes to evalate for 2nd condn
        // 4 is even? -> Yes then its next transformation map -> 4 * 2 - 8 -> FindFirst ( identify the first value)
        // so same 8 units of work
    infiniteStreamExample();
    }
    public static void infiniteStreamExample()
    {
        //Infinite Stream -> Not-Sized
        System.out.println(Stream.iterate(100, e -> e +1)); //start with 100, create series of 100, 101, 102 etc.
        //Above one,gives a pipeline on printing.
        //It doesn't perform or execute - until to perform any operation on it.
        //java.util.stream.ReferencePipeline$Head@27973e9b - o/p

        //Problem
        // Given a number K, and count n, find the total of double of n
        //even numbers starting with k, where sqrt of each number is > 20
        int k = 120;
        int n = 6;
        System.out.println(compute(k,n));
    }

    public static int compute(int k, int n)
    {
//        int result = 0;
//        int index = k;
//        int count = 0;
//        while(count < n)
//        {
//            if(index %2 == 0 && Math.sqrt(index) > 20)
//            {
//                result += index * 2;
//                count++;
//            }
//            index++;
//        }
//       return result;
        //Using Infinite Stream for the same problem
        return Stream.iterate(k,e -> e + 1)// unbounded, lazy
                .filter(e -> e % 2 == 0)//unbounded, lazy
                .filter( e -> Math.sqrt(e) > 20)//unbounded, lazy
                .mapToInt(e -> e * 2)//unbounded, lazy
                .limit(n) // sized or bounded, still lazy (Allows values till n)
                .sum(); // Terminal Operation - Triggers the operation
        //Anything returns Stream - its lazy. (Intermediate operations)

    }
    public static boolean isGT3(int e)
    {
        System.out.println("sss"); // Doesn't execute until Terminal Operations are executed.
        return e > 3;
    }

    public static boolean isEven(int e)
    {
        return e % 2 == 0;
    }

    public static int doubleIt(int e)
    {
        return e * 2;
    }
    /**
     * Characteristics of Stream
     *  1. Sized or Unsized
     *  2. Ordered or Un-Ordered.
     *  3. Distinct vs Non-Distinct
     *  4. Sorted vs Un-Sorted
     *
     *  numbers.stream()
     *          .filter(e -> e % 2 == 0)
     *          //.sorted()  // to sort the items
     *          .distinct() // To remove duplicates
     *          .forEach(System.out::println);
     *
     *
     */
}
