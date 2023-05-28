package org.ionn;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        ClassManager classManager = new ClassManager("org.ionn.Person");

        // Identify the package
        System.out.println(classManager.packageName());

        //Using reflection, extract as many information about the class (at least its methods).
        classManager.printMethods();
        classManager.printFields();

        //Using reflection, invoke the static methods, with no arguments, annotated with @Test.
        classManager.invokeTestMethodsWithNoArg();
    }

}