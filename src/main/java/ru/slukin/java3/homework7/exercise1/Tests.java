package ru.slukin.java3.homework7.exercise1;

public class Tests {
    @Test
    public static void testOne() {
        System.out.println("Testing from method 'testOne'");
    }

    @Test
    public static void testTwo() {
        System.out.println("Testing from method 'testTwo'");
    }

    @Test
    public static void testThree() {
        System.out.println("Testing from method 'testThree'");
    }

    @Test(priority = 0)
    public static void testLowPriority() {
        System.out.println("Testing from method 'testLowPriority'");
    }

    @Test(priority = 10)
    public static void testHighPriority() {
        System.out.println("Testing from method 'testHighPriority'");
    }

    @BeforeSuite
    public static void testBeforeSuiteOne() {
        System.out.println("Testing from method 'testBeforeSuiteOne'");
    }

//    @BeforeSuite
    public static void testBeforeSuiteTwo() {
        System.out.println("Testing from method 'testBeforeSuiteTwo'");
    }

    @AfterSuite
    public static void testAfterSuiteOne() {
        System.out.println("Testing from method 'testAfterSuiteOne'");
    }

//    @AfterSuite
    public static void testAfterSuiteTwo() {
        System.out.println("Testing from method 'testAfterSuiteTwo'");
    }
}
