package ru.slukin.java3.homework1.exercise2;

/*
ЗАДАНИЕ:
Написать метод, который преобразует массив в ArrayList.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise2 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(intArray) + " - " + intArray.getClass().getSimpleName());
        arrayToCollection(intArray);

        System.out.println();

        String[] stringArray = {"Первый", "Второй", "Третий", "Четвертый", "Пятый"};
        System.out.println(Arrays.toString(stringArray) + " - " + stringArray.getClass().getSimpleName());
        arrayToCollection(stringArray);
    }

    private static <T> void arrayToCollection(T[] array) {
        List<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        System.out.println(arrayList + " - " + arrayList.getClass().getSimpleName());
    }
}

