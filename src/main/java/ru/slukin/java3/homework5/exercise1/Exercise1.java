package ru.slukin.java3.homework5.exercise1;

/*
ЗАДАНИЕ:
Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не
может одновременно заехать больше половины участников (условность).
Попробуйте все это синхронизировать.
Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения
этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями
недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.
Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
пакета java.util.concurrent.
*/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Exercise1 {

    protected static final int CARS_COUNT = 6;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
        CountDownLatch countStart = new CountDownLatch(CARS_COUNT);
        CountDownLatch countFinish = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barrier, countStart, countFinish);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            countStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            countFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
