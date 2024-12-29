package learn.concepts;

public class InterfaceConceptWithExample {

    /**
     * Interface contains only Static variables and abstract methods
     *
     * Main Intention
     * 1. used to achieve abstraction
     * 2. Multiple Inheritance is achieved via Interface. One class can implement multiple interfaces. (But one
     * class can extend only one)
     * 3. Represents IS-A Relationship.
     *  4. Can be used for Loose Coupling.
     *
     *  In general, all variables are final, public, static.
     *  Methods are declared with empty body.
     *
     *  Interface can extend another Interface.
     *
     * Diff between Interface & abstract class.
     * - Abstract class can contain non-final variables.
     * But in Interface, all variables are public, static and final
     *
     * In Java 8, default method are allowed to have definition. This is to handle special case, where to add
     * methods to existing interfaces without affecting existing implementation (of downstream classes).
     *
     * interface sample {
     *     public void getName();
     *     int a = 10;
     *     default void display()
     *     {
     *         System.out.println("Default Implementation");
     *     }
     * }
     *
     * Another addition in Java 8 is, static methods can have definition, but its not inherited.
     * It can be invoked without any instance initiation.
     *
     *
     *
     */
}
