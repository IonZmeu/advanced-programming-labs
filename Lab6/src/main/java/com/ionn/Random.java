package com.ionn;

import java.util.Random;
class generateRandom {
    public static void main(String args[]) {
        //Creating an object of Random class
        Random random = new Random();
        //Calling the nextInt() method
        System.out.println("A random int: " + random.nextInt());
        //Calling the overloaded nextInt() method
        System.out.println("A random int from 0 to 49: " + random.nextInt(50));
        //Calling the nextDouble() method
        System.out.println("A random double: " + random.nextDouble());
        //Calling the nextFloat() method
        System.out.println("A random float: " + random.nextFloat());
        //Calling the nextLong() method
        System.out.println("A random long: " + random.nextLong());
    }
}
