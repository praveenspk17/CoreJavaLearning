package learn.basics;

public class ReversingNumber {

    public static void main(String[] args)
    {
        int digit = 2345768;
        int reverseValue = 0;
        int reminder = 0;
        //In order to reverse -> u have to dividing by 10 to get the reminder.
        //Have the reminder multiplied by 10 n add it back
        while(digit > 0)
        {
            reminder = digit % 10;
            reverseValue = (reverseValue * 10) + reminder;
            digit = digit/10;
        }
        // Printout of Reverse Value
        System.out.println("Reverse Value: " + reverseValue);
    }
}
