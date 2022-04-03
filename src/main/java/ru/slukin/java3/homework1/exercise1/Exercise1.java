package ru.slukin.java3.homework1.exercise1;

/*
ЗАДАНИЕ:
Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).
 */

import java.util.Arrays;
import java.util.Random;

public class Exercise1 {

    public static void main(String[] args) {
        Random random = new Random();

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Исходный массив: " + Arrays.toString(intArray));
        swapElements(intArray, random.nextInt(intArray.length + 1), random.nextInt(intArray.length + 1));

        System.out.println("---------------");

        String[] stringArray = {"Первый", "Второй", "Третий", "Четвертый", "Пятый"};
        System.out.println("Исходный массив: " + Arrays.toString(stringArray));
        swapElements(stringArray, random.nextInt(stringArray.length + 1), random.nextInt(stringArray.length + 1));
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        try {
            if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            exchange(array, index1, index2);
            System.out.println("Измененный массив: " + Arrays.toString(array));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверно указан индекс массива.");
        }
    }

    private static <T> void exchange(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
