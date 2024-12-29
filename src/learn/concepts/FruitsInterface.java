package learn.concepts;

public interface FruitsInterface {

    public void grow();
    public void eat();
    int minShellLife = 1;
    //Static methods in interface - should have definition
    static void printDummy()
    {
        System.out.println("Print Dummy - from Interface class of Static Method");
    }

    default void display()
    {
        System.out.println("This is default Method");
    }
}
