package learn.concepts;

public class AbstractClassConcepts {
    /**
     * Class is considered when it has atleast one abstract method.
     * Asbtract method -> means it doesn't have any definition
     *
     * Abstract classes -> cannot be instantiated.
     * Class that extends abstract class -> should define the implementation of the abstract method.
     *Abstract Keyword can be used for Class/ method -> Not for variable
     *
     * Main Pointers
     * 1. Abstract class cannot be instantiated
     * 2. Constructors are allowed. When the child class is getting instantiated, super class constructors are invoked
     * 3. We can have abstract class without any abstract method as well. (mainly for inheritance perspective)
     * 4. There can be final method in abstract class, which cannot be overridden. But abstract method cannot
     *    be marked as final.
     * 5. Static methods can be defined in Abstract class
     * 6. Abstract keyword can be used for top-level as well as Inner-level classes as well.
     *
     */
}
