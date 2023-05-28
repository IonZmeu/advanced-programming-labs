package org.ionn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class ExploreFolder {
    private static File file;

    public ExploreFolder(String inputPath) {
        file = new File(inputPath);
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
                    String className = filePath.substring(filePath.indexOf("classes") + 8, filePath.lastIndexOf('.'))
                            .replace(File.separatorChar, '.');
                    ClassManager classManager = new ClassManager(className);
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
                    // scoate din filepath classes\org\ionn\Main.class sare peste classes -> org\ionn\Main.class substring scapa de .class ->
                    // org\ionn\Main inlocuieste \ cu . -> org.ionn.Main
                    String className = filePath.substring(filePath.indexOf("classes") + 8, filePath.lastIndexOf('.'))
                            .replace(File.separatorChar, '.');
                    ClassManager classManager = new ClassManager(className);
                    classManager.invokeTestMethodsWithArg();
                }
            }
        }
    }
}
