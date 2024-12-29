package learn.basics;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Primitives {
    public static void main(String[] args) {
        //Sting[] args -> command line arguments
        //Primitive Type
        int value = 10;
        //By default, decimal values are considered as double. So append f at the end to indicate as float
        float decimalValue = 23.90f;
        //By default, integer values are considered as int. So append L at the end to indicate as long value
        long longValue = 23839383393293223L;
        double doubleValue = 23537373.38398292;
        boolean booleanValue = true;
        //Scanner - Is to process input data
        //System.in -> refers to the data typed from Keyboard (Ready to receive/ read data)
        Scanner input = new Scanner(System.in);
        System.out.print("Enter some number: ");
        //To read only Integer data
       // int intValue = input.nextInt();
        //to read the first word
        String firstWord = input.next();
        //to read entire line
        String line = input.nextLine();
        System.out.println(line);
        //Anything that starts with capital letter is called Class.
        // These are wrapper classes. They provide additional functionalities.
        Integer r = 44;
        //If you want to represent 234 million, instead of commas, we can use underscore - underscore will be ignored
        int millionValue = 234_000_000;
        System.out.println(millionValue);
        //234000000

        // Type Conversion
        //There is no error happens -> When we try store int to float , but other way -> it throws error.
        //bCoz int is smaller than float.
        //Type Casting

        int num = (int) 67.56f;
        System.out.println(num);
        //Print - 67

        //Automatic Type promotion in expressions
        int a = 257;
        byte b = (byte) a;
        System.out.println(b); //Print the value as 1, bcoz size of byte is 256. Since we are trying to assign
        //the value of 257, it subtract 256 - assigns the remaining

        byte aa = 40;
        byte bb = 50;
        byte cc = 20;
        int result = (aa * bb)/ cc;
        System.out.println(result); // Output: 100 -> During Evaluation of Expressions
        // Java automatically promotes the short/ byte to integer even though their data type length is exceeded.
        // Result is stored to Integer.
        byte bbb = 50;
        // byte ccc = bbb * 2; - This throws compilation error, bcoz -> expression -perform automatic type conversion
        // in this case - it convert to int

        // ANy language can be printed in Java. It follows UNICODE pattern
        System.out.println("தமிழ் தமிழ்");// Output தமிழ் தமிழ்
        //Review
        byte by = 40;
        char c =  'A';
        short s = 1024;
        int i = 232323;
        float f = 3.23f;
        double doub = 0.121131;
        double results = ((f * doub) + (i / c) + (doub * s));
        System.out.println(results); // Automatic conversion happens to a bigger data type value
        //Double 3698.4293971323104


    }
}
