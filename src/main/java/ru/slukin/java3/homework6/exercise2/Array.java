package ru.slukin.java3.homework6.exercise2;

public class Array {

    protected boolean checkArrayForNumbers(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;
        for (int element : array) {
            if (element == 1 && !containsOne) {
                containsOne = true;
                continue;
            }
            if (element == 4 && !containsFour) {
                containsFour = true;
                continue;
            }
            if (element != 1 && element != 4) {
                return false;
            }
        }
        return (containsOne && containsFour);
    }
}
