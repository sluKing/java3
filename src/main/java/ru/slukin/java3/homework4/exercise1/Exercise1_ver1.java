package ru.slukin.java3.homework4.exercise1;

/*
Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз.
Используйте wait/notify/notifyAll.
*/

public class Exercise1_ver1 {
    private static final Object monitor = new Object();
    private static char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(() -> printA()).start();
        new Thread(() -> printB()).start();
        new Thread(() -> printC()).start();
    }

    private static void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    monitor.notifyAll();
                    Thread.sleep(250);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    monitor.notifyAll();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    monitor.notifyAll();
                    Thread.sleep(750);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
