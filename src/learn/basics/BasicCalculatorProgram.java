package learn.basics;

import java.util.Scanner;

public class BasicCalculatorProgram {

    public static void main(String[] args)
    {
        //To accept values from the keyword n perform basic arithmetic operations
        //Plan is to perform operations until Key value of X or x is entered.

        while(true)
        {
            System.out.print("Enter the arithmetic operator: ");
            Scanner input = new Scanner(System.in);
            char operator = input.next().trim().charAt(0);
            if(operator == '+' || operator == '-' || operator == '*' || operator == '/')
            {
                System.out.print("Enter 2 numbers: ");
                int a = input.nextInt();
                int b = input.nextInt();
                int result  = 0;
                if(operator == '+')
                {
                    result = a + b;
                }
                else if(operator == '-')
                {
                    result = a - b;
                }
                else if(operator == '*')
                {
                    result = a * b;
                }
                else if(operator == '/')
                {
                    result = a / b;
                }
                System.out.println("Result: " + result);
            }
            else if(operator == 'X' || operator == 'x')
            {
                System.out.println("End of Operation");
                break;
            }
            else
            {
                System.out.println("Invalid Operator");
            }
        }



    }
}
