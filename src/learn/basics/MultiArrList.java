package learn.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiArrList {

    public static void main(String[] args) {
        //To define Multi Dimensional ArrayList
        List<ArrayList<Integer>> multiArr = new ArrayList<>();
        // First let us initialize (the inner ArrayList) -> in case of 3 list within
        for(int i = 0; i < 3; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            multiArr.add(list);

        }
        // To take input values
        Scanner input = new Scanner(System.in);
        //Considering the size of 3
        for(int i = 0; i <3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                List aa = multiArr.get(i);
                aa.add(input.nextInt());
            }
        }
        // To print the response
        for(int i = 0; i <3; i++)
        {
            System.out.println(multiArr.get(i));
        }
        /**
         * 1
         * 2
         * 3
         * 4
         * 5
         * 5
         * 6
         * 7
         * 8
         * [1, 2, 3]
         * [4, 5, 5]
         * [6, 7, 8]
         *
         */
    }

}
