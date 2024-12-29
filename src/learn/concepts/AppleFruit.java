package learn.concepts;

public class AppleFruit implements FruitsInterface{
    @Override
    public void grow() {
        //Cannot assign a new value to a variable within Interface -> In general all variables within Interface are public, static anf final
        //FruitsInterface.minShellLife = 1;
        System.out.println("Grow method for Apple");
    }

    @Override
    public void eat() {
        System.out.println("Eat method for Apple");

    }

}

class MainClass
{
    public static void main(String[] args) {
        FruitsInterface apple = new AppleFruit();
        apple.grow();
        //Default method (Whoever wants can use it, it need not be implemented by each class
        apple.display();
        //Invoking Static Method & Variable
        FruitsInterface.printDummy();
        System.out.println("Interface Variable Value: " + FruitsInterface.minShellLife);
    }
}
