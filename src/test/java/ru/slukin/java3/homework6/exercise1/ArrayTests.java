package ru.slukin.java3.homework6.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayTests {
    Array newArray;

    @BeforeEach
    public void init() {
        newArray = new Array();
    }

    public static Stream<Arguments> dataForEquals() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{5, 6, 7, 8}, 4));
        out.add(Arguments.arguments(new int[]{4, 5, 6, 7, 8}, new int[]{6, 7, 8}, 5));
        out.add(Arguments.arguments(new int[]{6, 7, 8, 4}, new int[]{7, 8, 4}, 6));
        out.add(Arguments.arguments(new int[]{6, 7, 8, 4}, new int[]{8, 4}, 7));
        out.add(Arguments.arguments(new int[]{6, 7, 8, 4}, new int[]{4}, 8));
        out.add(Arguments.arguments(new int[]{4}, new int[]{}, 4));
        return out.stream();
    }

    public static Stream<Arguments> dataForCheckException() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5, 6, 7, 8, 3, 1}, 4));
        out.add(Arguments.arguments(new int[]{6, 7, 8, 4, 2}, 5));
        out.add(Arguments.arguments(new int[]{7, 8, 4, 3}, 6));
        out.add(Arguments.arguments(new int[]{8, 4, 5}, 7));
        out.add(Arguments.arguments(new int[]{4, 9}, 8));
        out.add(Arguments.arguments(new int[]{3}, 9));
        out.add(Arguments.arguments(new int[]{}, 10));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForEquals")
    public void checkArrayForEquals(int[] sourceArray, int[] changedArray, int desNumber) {
        Assertions.assertArrayEquals(changedArray, newArray.createNewArrayAfterDesiredNumber(sourceArray, desNumber));
    }

    @ParameterizedTest
    @MethodSource("dataForCheckException")
    public void checkException(int[] sourceArray, int desNumber) {
        Assertions.assertThrows(RuntimeException.class, () -> newArray.createNewArrayAfterDesiredNumber(sourceArray, desNumber));
    }
}
