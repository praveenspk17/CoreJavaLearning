package learn.basics;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysAndList {
    public static void main(String[] args){
        //
        int arr[]; // Declaration -> Compile time - variable is created in Stack
       // arr = new int[5]; // Initialization - Dynamic Memory allocation happens in Heap Memory
        // By default, heap memory is not continuous.
        // when values are not initialized, default value of integer array elements is 0.
        //But default value for element in String array is null.
        //Primtive Types - int, char, float, boolean - are stored in Stack
        //Objects -> String, HashMap, Integer  -> Objects are stored as Heap
        //Until Objects are initialized - Objects are references -> they will not point to any value
        // So it would be null
        arr = new int[] {11,2,3};
        //Java 8 Streams with Method References to print out each value of array
        Arrays.stream(arr).forEach(System.out::print);
       // System.out.println(); - 11,2,3

        methodCallToUpdate(arr);
        Arrays.stream(arr).forEach(System.out::print);
         // 33,2,3
        // 2-Dimensional Arrays (first value represents row (3) -> Its mandatory
        //2nd column represents columns - it's not mandatory to declare, it can be dynamic.
        //Within Heap memory, data is stored as array of arrays (each individual array is an object by itself, so no need to specify  the size
        /**
         * Example of 2D Array
         *  1 ,2,3
         *  3,4,5
         *  6,7,8,9
         *....
         * Data would be stored as [[1,2,3] , [3,4,5], [6,7,8,9] ]
         * arr2D[0] (1st Index is) = [1,2,3]
         * arr2D[0][1] = 2 (1st row, 2nd value)
         *
         */
        System.out.println("Provide Input for 2D Array");
        Scanner input = new Scanner(System.in);

        int[][] arr2Dim = new int[3][2];
        for(int row = 0; row < arr2Dim.length; row++)
        {
            //For Each Row
            for(int column = 0; column < arr2Dim[row].length; column++)
            {
                arr2Dim[row][column] = input.nextInt();
            }
        }
        //To print the Scanner Response
        for(int row = 0; row < arr2Dim.length; row++)
        {
            //For Each Row
            for(int column = 0; column < arr2Dim[row].length; column++)
            {
                System.out.print(arr2Dim[row][column]);
            }
            //For a new line, to show results in Matrix Format
            System.out.println();
        }

        // With Enhanced For Loop - Println:
        for(int[] a : arr2Dim)
        {
            System.out.println(Arrays.toString(a));
        }
        /**
         * Provide Input for 2D Array
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 12
         * 34
         * 56
         * [1, 2]
         * [3, 4]
         * [5, 6]
         */
        //Arrays are most of fixed size.
        //If you dont know the size of inputs, u want to keep adding - u can go for Array List.

    }

    /**
     * Value update happens here.
     * Whenver a method call is done, pAss by Reference:
     * Reference to the object is passed. So both arr and array variable to point to same object.
     * So any updates in this method, will update the original arr value as well
     * Arrays are mutable. But Strings are immutable
     * V
     * @param array
     */
    public static void methodCallToUpdate(int[] array){
        array[0]= 33;

    }

}
