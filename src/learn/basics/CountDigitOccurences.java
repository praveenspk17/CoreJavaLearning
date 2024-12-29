package learn.basics;

import java.util.Scanner;

public class CountDigitOccurences {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Digit: ");
        int value = input.nextInt();
        //Find no of occurrence of value 4
        int find = 4;
        int index = 0;
        //int count = value/10;
        int reminder = 0;
        while(value > 0)
        {
            reminder = value % 10;
            if(reminder == 4)
            {
                index++;
            }
            value = value/10;
        }

        System.out.println("No of Occurrences: " + index);
    }
}
