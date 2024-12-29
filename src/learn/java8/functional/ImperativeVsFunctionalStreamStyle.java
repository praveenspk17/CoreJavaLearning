package learn.java8.functional;

import java.util.Arrays;
import java.util.List;

public class ImperativeVsFunctionalStreamStyle {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Logic ->
        //Given the values, double the even numbers and Total
        //Imperative Style
        int total = 0;
        for(Integer e : numbers)
        {
            if( e % 2 == 0)
                total += e * 2;
        }
        System.out.println(total);
        // Functional Style - Stream (Smooth iteration)-> Iterative Style
      /*  System.out.println(
        numbers.stream()
                .filter(e -> e%2 == 0)
                .map(e -> e * 2)
                .reduce(0, Integer::sum));*/
        System.out.println(
                numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e * 2)
                .sum());
        // Function COmposition -> Series of events/ steps . Kind of Pipeline
    }
}
