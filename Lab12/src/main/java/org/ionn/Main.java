package org.ionn;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        person.setName("Ion");
        person.setAge(20);
        System.out.println(getFieldNames(Person.class.getFields()));
        System.out.println(getFieldNames(person.getClass().getDeclaredFields()));
        for (Method m : Person.class.getDeclaredMethods()
             ) {
            System.out.println(m);
        }

        dinamicallyCheckClasses("org.ionn.Person");


//        ClassLoader classLoader = Main.class.getClassLoader();
//        MyClassLoader myClassLoader = new MyClassLoader(classLoader);
//        Class roadClass = myClassLoader.loadClass("Road");
//        System.out.println(roadClass.getName());
    }

    private static void dinamicallyCheckClasses(String className){
        ClassLoader classLoader = Main.class.getClassLoader();
        try {
            Class aClass = classLoader.loadClass(className);
            System.out.println("aClass.getDeclaredMethods() = " + aClass.getDeclaredMethods()[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);
        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }

    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
}