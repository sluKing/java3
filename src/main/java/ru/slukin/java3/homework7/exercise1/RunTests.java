package ru.slukin.java3.homework7.exercise1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunTests {
    private static List<Method> methodList;
    private static Method[] methods;

    public static void start(Class testClass) {
        methodList = new ArrayList<>();
        methods = testClass.getDeclaredMethods();

        sortAndAddInArrayTestMethods();
        checkAndAddInArrayBeforeAndAfterSuite();
        runMethods();
    }

    private static void checkAndAddInArrayBeforeAndAfterSuite() {
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                methodList.add(0, method);
                countBeforeSuite++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                methodList.add(method);
                countAfterSuite++;
            }
        }
        if (countBeforeSuite > 1) {
            throw new RuntimeException("@BeforeSuite > 1");
        }
        if (countAfterSuite > 1) {
            throw new RuntimeException("@AfterSuite > 1");
        }
    }

    private static void runMethods() {
        for (Method method : methodList) {
            try {
                method.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void sortAndAddInArrayTestMethods() {
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }
        }
        methodList.sort(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).priority()).reversed());
    }
}
