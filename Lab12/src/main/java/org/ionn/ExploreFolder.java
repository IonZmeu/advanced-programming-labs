package org.ionn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class ExploreFolder {
    private static File file;
    private static MyClassLoader myClassLoader;

    public ExploreFolder(MyClassLoader myClassLoader,String inputPath) {
        file = new File(inputPath);
        this.myClassLoader = myClassLoader;
    }

    public static void printFieldsOfAllClasses() throws ClassNotFoundException {
        printFieldsOfAllClasses(file);
    }

    public static void printFieldsOfAllClasses(File folder) throws ClassNotFoundException {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFieldsOfAllClasses(file);
                } else if (file.getName().endsWith(".class")) {
                    String filePath = file.getAbsolutePath();
                    ClassManager classManager = new ClassManager(myClassLoader,filePath);
                    classManager.printFields();
                }
            }
        }
    }

    public static void invokeMethodsFromClassesAnnotatedWithTest() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        invokeMethodsFromClassesAnnotatedWithTest(file);
    }


    public static void invokeMethodsFromClassesAnnotatedWithTest(File folder) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    invokeMethodsFromClassesAnnotatedWithTest(file);
                } else if (file.getName().endsWith(".class")) {
                    String filePath = file.getAbsolutePath();
                    ClassManager classManager = new ClassManager(myClassLoader,filePath);
                    classManager.invokeTestMethodsWithArg();
                }
            }
        }
    }

}
