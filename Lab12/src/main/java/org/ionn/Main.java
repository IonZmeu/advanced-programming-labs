package org.ionn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        /*
        ClassManager classManager = new ClassManager("org.ionn.Person");
        // Identify the package
        System.out.println(classManager.packageName());
        //Using reflection, extract as many information about the class (at least its methods).
        classManager.printMethods();
        classManager.printFields();
        //Using reflection, invoke the static methods, with no arguments, annotated with @Test.
        classManager.invokeTestMethodsWithNoArg();
        */

        ExploreFolder exploreFolder = new ExploreFolder("D:\\facultateanul2sem1\\sem2\\advanced-programming-labs\\Lab4");
        exploreFolder.printFieldsOfAllClasses();
        //exploreFolder.invokeMethodsFromClassesAnnotatedWithTest();
    }

}