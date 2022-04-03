package ru.slukin.java3.homework6.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayTests {
    Array intArray;

    public static Stream<Arguments> dataForCheckOnTrue() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        out.add(Arguments.arguments(new int[]{6, 7, 8, 4}, false));
        out.add(Arguments.arguments(new int[]{4}, false));
        out.add(Arguments.arguments(new int[]{1, 4}, true));
        return out.stream();
    }

    public static Stream<Arguments> dataOfCorrectArrays() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 1, 1}, true));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 1}, true));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 1}, true));
        out.add(Arguments.arguments(new int[]{1, 4, 1, 4}, true));
        out.add(Arguments.arguments(new int[]{4, 1}, true));
        out.add(Arguments.arguments(new int[]{1, 4}, true));
        return out.stream();
    }

    @BeforeEach
    public void init() {
        intArray = new Array();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckOnTrue")
    public void checkArraysOnTrue(int[] array, boolean result) {
        Assertions.assertEquals(result, intArray.checkArrayForNumbers(array));
    }

    @ParameterizedTest
    @MethodSource("dataOfCorrectArrays")
    public void checkCorrectArraysOnEquals(int[] array, boolean result) {
        Assertions.assertEquals(result, intArray.checkArrayForNumbers(array));
    }

    @ParameterizedTest
    @MethodSource("dataOfCorrectArrays")
    public void checkCorrectArraysOnTrue(int[] array) {
        Assertions.assertTrue(intArray.checkArrayForNumbers(array));
    }
}
