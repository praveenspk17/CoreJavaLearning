package learn.basics;

public class BasicQuestions {

    public static void main(String[] args) {
        //Prime -> Should be divided only by 1 or itself.
        // Logic -> We can have a loop to see whether any number can divide n provide reminder of 0 -> until its half.
        int num = 29;
        boolean isPrime = true;
        for(int i = 2; i <= num/2; i++)
        {
            if(num % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime);

        System.out.println("Is it armstrong Number? " + isArmstrongNumber(153));
    }
    // What is Armstrong number - consider example of 3 digit
    // summing up the cube value of each single digit -> gives the total value -> then its armstrong no
    static boolean isArmstrongNumber(int n)
    {
        int original = n;
        int sum = 0;
        while(n > 0)
        {
            int rem = n%10;
            n = n/10;
            sum = sum + (rem * rem * rem);
        }
        return original == sum;
    }
}
