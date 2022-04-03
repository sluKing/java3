package ru.slukin.java3.homework6.exercise1;

public class Array {

    protected int[] createNewArrayAfterDesiredNumber(int[] array, int desNumber) {
        if (array.length == 0) {
            throw new RuntimeException("The source array is empty.");
        }
        int[] newArray;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == desNumber) {
                newArray = new int[array.length - (i + 1)];
                System.arraycopy(array, (i + 1), newArray, 0, (array.length - (i + 1)));
                return newArray;
            }
        }
        throw new RuntimeException("The source array does not contain a four.");
    }
}
