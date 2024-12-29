package learn.java8;

import java.security.spec.RSAOtherPrimeInfo;

public class AnonymousInnerClassExample {

    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        });
        System.out.println("Before Thread Invocation");
        th.start();
        System.out.println("After Thread Invocation");
        System.out.println("In Main - Inner Class");
    }
}
/**
 * Before Thread Invocation
 * After Thread Invocation
 * In Main - Inner Class
 * Inside Runnable
 */