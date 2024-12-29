package learn.search;

public class LinearSearchEvenOfDigitsInArray {
    public static void main(String[] args) {
        int[] arr = {23,123, 4567,22,1};
        int noOfDigits = 0;
        for(int ele : arr)
        {
            if(Integer.toString(ele)
                    .length() % 2 == 0)
                    noOfDigits++;
        }
        /**
         * Instead of above, below can be utilized
         * while(n > 0)
         * {
         *      n = n/10;
         *      count++;
         *  }
         *  // ANother way to find no of digit
         *  (int)Math.log10(num) + 1 ==>
         */
        System.out.println("No of Even Digits: " + noOfDigits);
    }
}
