package learn.java8.functional;
import java.util.List;
import java.util.Arrays;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //To understand time taken - let us use -
        long startTime = System.nanoTime();
        System.out.println(
                numbers.stream()
                        .filter(e -> e %2 ==0)
                        .mapToInt(e -> compute(e))// Using Lambda
                        //.mapToInt(ParallelStreamExample::compute) // Usingh Method Reference
                        .sum());
        long endTime = System.nanoTime();
        //To convert output to Milliseconds - Divide by 1,000,000.
        long timeDuration = (endTime - startTime)/ 1000000;
        System.out.println(timeDuration);
        //In case of paraellel Stream
        startTime = System.nanoTime();
        System.out.println(
                numbers.parallelStream()
                        .filter(e -> e %2 ==0)
                        .mapToInt(e -> compute(e))// Using Lambda
                        //.mapToInt(ParallelStreamExample::compute) // Usingh Method Reference
                        .sum());
        endTime = System.nanoTime();
        //To convert output to Milliseconds - Divide by 1,000,000.
        timeDuration = (endTime - startTime)/ 1000000;
        System.out.println(timeDuration);

        /**
         * With Normal Streams
         * 60
         * 5030
         * Using Parallel Streams - Same O/p, But time has reduced - More resources are utiilized.
         *
         * 60
         * 1021
         *
         * Use ParallelStreams in  below Scenarios
         * 1. One problem is parallelizable.
         * 2. Willing to spend extra resources.
         * 3. Data set is huge, so that we can get/ realize better performance
         * 4. Compute logic is complex to get better perf
         *
         */


        //If STream takes 5 Seconds to performc compute.
        //ParallelStream would take around 1 sec. But is it really worth to use all the resources.



    }

    public static int compute(int e)
    {
        //assuming time intensive tasks
        try{
            Thread.sleep(1000);
        }
        catch(Exception exe) {

        }
        return e * 2;
    }
}
