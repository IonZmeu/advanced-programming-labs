package org.ionn;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ClassManager {
    private Class<?> loadedClass;
    private String className;

    private String absolutePath;

    public ClassManager(MyClassLoader myClassLoader,String filePath) throws ClassNotFoundException {
        this.absolutePath = filePath;
        // scoate din filepath classes\org\ionn\Main.class sare peste classes -> org\ionn\Main.class substring scapa de .class ->
        // org\ionn\Main inlocuieste \ cu . -> org.ionn.Main
        className = filePath.substring(filePath.indexOf("classes") + 8, filePath.lastIndexOf('.'))
                .replace(File.separatorChar, '.');

        loadedClass = myClassLoader.loadClass(absolutePath, className);
    }

    public String packageName() {
        Package classPackage = loadedClass.getPackage();
        return classPackage.getName();
    }

    public void printMethods() {
        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();
        for (Method method : methodList
        ) {
            System.out.println(method);
        }
    }

    public void printFields() {
        List<Field> fieldList = Arrays.stream(loadedClass.getDeclaredFields()).toList();
        for (Field field : fieldList
        ) {
            System.out.println(field);
        }
    }

    public void invokeTestMethodsWithNoArg() throws InvocationTargetException, IllegalAccessException {
        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();
        for (Method method : methodList
        ) {
            if (Modifier.isStatic(method.getModifiers()) && method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0) {
                method.invoke(null);
            }
        }
    }

    //Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.
    //If a method requires primitive (at least int) or String arguments, generate mock values for them.
    public void invokeTestMethodsWithArg() throws InvocationTargetException, IllegalAccessException {
        List<Method> methodList = Arrays.stream(loadedClass.getMethods()).toList();

        if (Modifier.isPublic(loadedClass.getModifiers())) {
            for (Method method : methodList) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] args = new Object[parameterTypes.length];

                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> paramType = parameterTypes[i];

                    if (paramType == int.class || paramType == Integer.class) {
                        // Generate a mock integer value
                        args[i] = 25;
                    } else if (paramType == String.class) {
                        // Generate a mock string value
                        args[i] = "test string";
                    }
                }

                if (method.isAnnotationPresent(Test.class)) {
                    method.invoke(null,args);
                }
            }
        }
    }

}
