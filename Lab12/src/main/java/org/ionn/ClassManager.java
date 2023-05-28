package org.ionn;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

public class ClassManager {
    private String className;
    private Class<?> loadedClass;

    public ClassManager(String className) throws ClassNotFoundException {
        this.className = className;
        loadedClass = Class.forName(className);
    }

    public String packageName(){
        Package classPackage = loadedClass.getPackage();
        return classPackage.getName();
    }

    public void printMethods(){
        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();
        for (Method method: methodList
        ) {
            System.out.println(method);
        }
    }

    public void printFields(){
        List<Field> fieldList = Arrays.stream(loadedClass.getDeclaredFields()).toList();
        for (Field field: fieldList
        ) {
            System.out.println(field);
        }
    }

    public void invokeTestMethodsWithNoArg() throws InvocationTargetException, IllegalAccessException {
        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();
        for (Method method: methodList
        ) {
            if (Modifier.isStatic(method.getModifiers()) && method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }
    }

}
