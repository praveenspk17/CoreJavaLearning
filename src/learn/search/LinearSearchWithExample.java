package learn.search;

public class LinearSearchWithExample {

    public static void main(String[] args) {
        /**
           * Linear Search -> Trying to find element by searching one by one
           * from left to right
         *
         * Big(O) -> Big O notation ->
         * For Best Case -> O(1) -> No of searches it would take to identify the first element
         * For Worst case O(N) -> No of searches will be till Nth element.
           *
         *
         * What is Constant Complexity
         * -> For Best Case Scenario,
         * Irrespective of the size of the array -> always the time taken to find a element is always constant (like eg: 1ms)
         *
         * What is Linear Complexity
         * -> For Worst Case Scenario,
         * As the size of the array grows -> time it takes to find the specified element also grows -> Linear way (if u draw a graph)
         *
         * Big of O, -> means - > it never go beyond the time N.
         */

        int[] arr = {1,55,66,88,33,77};
        int target = 99;
        int searchIndex = linearSearch(arr, target);
        System.out.println("Correct Index Value: " + searchIndex);

        String name = "Praveen";
        char targetChar = 'q';
        boolean found = searchInString(name,targetChar);
        System.out.println("Character Found: " + found);

    }

    static int linearSearch(int[] arr, int target)
    {
        if(arr.length == 0)
            return -1;
        for(int index = 0; index < arr.length; index++)
        {
            int element = arr[index];
            if(element == target)
            {
                return index;
            }
        }
        return -1;
    }

    static boolean searchInString(String name, char field)
    {
        boolean found = false;
        if(name.isEmpty())
            return false;
        char[] charArr = name.toCharArray();
        for(char a : charArr)
        {
            if(a == field)
                return true;
        }
        return found;
    }
}
