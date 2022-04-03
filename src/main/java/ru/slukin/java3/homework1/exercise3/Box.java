package ru.slukin.java3.homework1.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    List<T> fruitBox = new ArrayList<>();

    protected void add(T fruit) {
        this.fruitBox.add(fruit);
    }

    protected double getWeight() {
        double weight = 0.0f;
        for (T fruit : this.fruitBox) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    protected void moveFruitsIntoBox(Box<T> otherBox) {
        for (T fruit : this.fruitBox) {
            otherBox.add(fruit);
        }
        this.fruitBox.clear();
    }

    protected boolean compareTo(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) <= 0.000001;
    }
}
