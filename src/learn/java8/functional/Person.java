package learn.java8.functional;

public class Person {
    int age;
    String name;
    Gender gender;
    public enum Gender{
        MALE, FEMALE
    }

    public Person(String name, Gender gender, int age) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
