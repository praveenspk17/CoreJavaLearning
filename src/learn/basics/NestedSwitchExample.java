package learn.basics;

import java.util.Scanner;

public class NestedSwitchExample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a fruit name");
        String word = input.next();

        // Syntax -> Switch of Expression -> For Case it should be constant or expression result
        //Case should not contain duplicates
        //Break -> is to break after execution of one condition n come out of loop.
        //If Break is not added, all of the following cases would get executed until Break comes.
        //If i give Banana, o/p is
//        Enter a fruit name
//        banana
//        Its Banana
//        Its Orange
        switch(word)
        {
            case "apple":
                System.out.println("Its apple");
                break;
            case "banana":
                System.out.println("Its Banana");

            case "orange":
                System.out.println("Its Orange");
                break;
            default:
                System.out.println("ENter Fruit name");
        }

        //Enhanced Switch is // without Break
        switch(word){
            case "apple" -> System.out.println("Its apple");
            case "Banana","Orange" -> System.out.println("Its a combination");
            default -> System.out.println("Provide Valid food");

        }
    }
}
