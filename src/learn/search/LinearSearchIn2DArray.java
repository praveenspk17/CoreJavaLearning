package learn.search;

import java.util.Arrays;

public class LinearSearchIn2DArray {

    public static void main(String[] args) {
        int[][] doubleDimArr = {
                {14,6,5},
                {44,66,1,11},
                {33,53,90}
        };
        int target = 53;
        int[] finalValue = search(doubleDimArr, target);
        System.out.println(Arrays.toString(finalValue));

    }
    //2D Array -> is like Array of Arrays
    static int[] search(int[][] arr, int target){
        if(arr.length == 0)
            return new int[] {-1};
        for(int row = 0; row < arr.length; row++)
        {
            for(int col = 0; col < arr[row].length; col++)
            {
                if(arr[row][col] == target)
                    return new int[] {row, col};
            }
        }
        return new int[] {-1};
    }

}
