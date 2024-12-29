package learn.basics;

import learn.java8.functional.Person;

import java.util.Arrays;

public class ArraysCommonExamples {

    public static void main(String[] args) {
        int arr[] = {2,6,22,78,12};
        System.out.println(Arrays.toString(arr));
        swapIndexes (arr, 1,3);
        System.out.println(Arrays.toString(arr));
        // To print max element in the array
        printMaxElement(arr);
        // To reverse an array
        // We can use start and endIndex, keep swapping them, until startIndex  is greater than ENd Index
        int start = 0;
        int end = arr.length - 1;
        while(start < end)
        {
            swapIndexes(arr, start, end);
            start++;
            end--;
        }
        System.out.println("After Reversal: " + Arrays.toString(arr));
        /**
         * [2, 6, 22, 78, 12]
         * [2, 78, 22, 6, 12]
         * Maximum Value: 78
         * After Reversal: [12, 6, 22, 78, 2]
         */
    }

    static void swapIndexes(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void printMaxElement(int[] arr)
    {
        int max = arr[0];
        for(int i = 1 ; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println("Maximum Value: " + max);
    }


}
