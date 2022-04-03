package ru.slukin.java3.homework4.exercise1;

/*
Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз.
Используйте wait/notify/notifyAll.
*/

public class Exercise1_ver2 {
    private static final Object monitor = new Object();
    private static char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(() -> printLetter('A', 'B', 250)).start();
        new Thread(() -> printLetter('B', 'C', 500)).start();
        new Thread(() -> printLetter('C', 'A', 750)).start();
    }

    private static void printLetter(char A, char B, int sleepTime) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != A) {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = B;
                    monitor.notifyAll();
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
