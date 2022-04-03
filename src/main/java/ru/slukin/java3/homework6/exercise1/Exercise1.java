package ru.slukin.java3.homework6.exercise1;

/*
Написать метод, которому в качестве аргумента передается не пустой одномерный
целочисленный массив. Метод должен вернуть новый массив, который получен путем
вытаскивания из исходного массива элементов, идущих после последней четверки. Входной
массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {
        Array newArray = new Array();
        int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] array2 = {1, 2, 3, 1, 4};
        int[] array3 = {4, 2, 3, 1, 7};
        int[] array4 = {1, 2, 3, 1, 7};
        int[] array5 = {};

        System.out.println("Source array 1: " + Arrays.toString(array1));
        int[] changedArray1 = newArray.createNewArrayAfterDesiredNumber(array1, 4);
        System.out.println("Result 1: " + Arrays.toString(changedArray1) + "\n");

        System.out.println("Source array 2: " + Arrays.toString(array2));
        int[] changedArray2 = newArray.createNewArrayAfterDesiredNumber(array2, 4);
        System.out.println("Result 2: " + Arrays.toString(changedArray2) + "\n");

        System.out.println("Source array 3: " + Arrays.toString(array3));
        int[] changedArray3 = newArray.createNewArrayAfterDesiredNumber(array3, 4);
        System.out.println("Result 3: " + Arrays.toString(changedArray3) + "\n");

        try {
            System.out.println("Source array 4: " + Arrays.toString(array4));
            int[] changedArray4 = newArray.createNewArrayAfterDesiredNumber(array4, 4);
            System.out.println("Result 4: " + Arrays.toString(changedArray4) + "\n");
        } catch (RuntimeException e) {
            System.err.println("Result 4: the source array does not contain a four.");
        }

        try {
            System.out.println("Source array 5: " + Arrays.toString(array5));
            int[] changedArray5 = newArray.createNewArrayAfterDesiredNumber(array5, 2);
            System.out.println("Result 5: " + Arrays.toString(changedArray5) + "\n");
        } catch (RuntimeException e) {
            System.err.println("Result 5: the source array is empty.");
        }
    }


}
