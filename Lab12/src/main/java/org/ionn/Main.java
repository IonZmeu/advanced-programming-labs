package org.ionn;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> loadedClass = Class.forName("org.ionn.Person");

        // Identify the package
        Package classPackage = loadedClass.getPackage();
        String packageName = classPackage != null ? classPackage.getName() : "(default package)";
//        System.out.println(packageName);
        //Using reflection, extract as many information about the class (at least its methods).

        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();
//        for (Method method: methodList
//             ) {
//            System.out.println(method);
//        }
//
//        List<Field> fieldList = Arrays.stream(loadedClass.getDeclaredFields()).toList();
//        for (Field field: fieldList
//             ) {
//            System.out.println(field);
//        }

        //Using reflection, invoke the static methods, with no arguments, annotated with @Test.

        for (Method method: methodList
        ) {
            if (Modifier.isStatic(method.getModifiers()) && method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }

        //
    }

}