package ru.slukin.java3.homework5.exercise1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final Lock LOCK = new ReentrantLock();
    private final CyclicBarrier barrier;
    private final CountDownLatch countStart;
    private final CountDownLatch countFinish;
    private final Race race;
    private final int speed;
    private final String name;

    static {
        CARS_COUNT = 0;
    }

    public Car(Race race, int speed, CyclicBarrier barrier, CountDownLatch countStart, CountDownLatch countFinish) {
        this.race = race;
        this.speed = speed;
        this.barrier = barrier;
        this.name = "Участник #" + ++CARS_COUNT;
        this.countStart = countStart;
        this.countFinish = countFinish;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            countStart.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (countFinish.getCount() == CARS_COUNT && LOCK.tryLock()) {
            System.out.println(this.getName() + " >>> ПОБЕДИТЕЛЬ!!!");
            LOCK.unlock();
        }
        if (countFinish.getCount() == 1) {
            System.out.println(this.getName() + " >>> ФИНИШИРОВАЛ ПОСЛЕДНИМ...");
        }
        countFinish.countDown();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
