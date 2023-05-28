package org.ionn;


import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, MalformedURLException {
        MyClassLoader myClassLoader = new MyClassLoader(MyClassLoader.class.getClassLoader());

        ClassManager classManager = new ClassManager(myClassLoader,"D:\\facultateanul2sem1\\sem2\\advanced-programming-labs\\Lab12\\target\\classes\\org\\ionn\\Person.class");
        // Identify the package
        System.out.println("///////////////////////////////packageName///////////////////////////////");
        System.out.println(classManager.packageName());
        //Using reflection, extract as many information about the class (at least its methods).
        System.out.println("///////////////////////////////printMethods///////////////////////////////");
         classManager.printMethods();
        System.out.println("///////////////////////////////printFields///////////////////////////////");
         classManager.printFields();
        //Using reflection, invoke the static methods, with no arguments, annotated with @Test.
        System.out.println("///////////////////////////////invokeTestMethodsWithNoArg///////////////////////////////");
         classManager.invokeTestMethodsWithNoArg();


        //ExploreFolder exploreFolder = new ExploreFolder(myClassLoader,"D:\\facultateanul2sem1\\sem2\\advanced-programming-labs\\Lab4");
        //exploreFolder.invokeMethodsFromClassesAnnotatedWithTest();


    }

}