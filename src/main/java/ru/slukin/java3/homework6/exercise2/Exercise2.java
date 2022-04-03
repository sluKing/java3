package ru.slukin.java3.homework6.exercise2;

/*
Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4
варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
 */

import java.util.Arrays;

public class Exercise2 {

    public static void main(String[] args) {
        Array array = new Array();

        int[] array1 = {1, 1, 1, 4, 4, 1, 4, 4};
        System.out.println("Source array 1: " + Arrays.toString(array1));
        System.out.println("Result 1: " + array.checkArrayForNumbers(array1) + "\n");

        int[] array2 = {1, 1, 1, 1, 1, 1};
        System.out.println("Source array 2: " + Arrays.toString(array2));
        System.out.println("Result 2: " + array.checkArrayForNumbers(array2) + "\n");

        int[] array3 = {4, 4, 4, 4};
        System.out.println("Source array 3: " + Arrays.toString(array3));
        System.out.println("Result 3: " + array.checkArrayForNumbers(array3) + "\n");

        int[] array4 = {1, 4, 4, 1, 1, 4, 3};
        System.out.println("Source array 4: " + Arrays.toString(array4));
        System.out.println("Result 4: " + array.checkArrayForNumbers(array4) + "\n");
    }
}
