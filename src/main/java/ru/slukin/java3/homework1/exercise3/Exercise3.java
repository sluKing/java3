package ru.slukin.java3.homework1.exercise3;

/*
ЗАДАНИЕ:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */

public class Exercise3 {

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.printf("Вес коробки с яблоками № 1: %.2f кг.%n", appleBox1.getWeight());
        System.out.printf("Вес коробки с яблоками № 2: %.2f кг.%n", appleBox2.getWeight());
        System.out.printf("Вес коробки с апельсинами: %.2f кг.%n", orangeBox.getWeight());

        System.out.println(appleBox1.compareTo(orangeBox)
                ? "Вес коробки № 1 с яблоками равен весу коробки с апельсинами."
                : "Вес коробки № 1 с яблоками не равен весу коробки с апельсинами.");
        System.out.println(appleBox2.compareTo(orangeBox)
                ? "Вес коробки № 2 с яблоками равен весу коробки с апельсинами."
                : "Вес коробки № 2 с яблоками не равен весу коробки с апельсинами.");

        System.out.println("\nПерекладываем яблоки из коробки № 1 в коробку № 2...\n");

        appleBox2.moveFruitsIntoBox(appleBox1);
        System.out.printf("Вес коробки с яблоками № 1: %.2f кг.%n", appleBox1.getWeight());
        System.out.printf("Вес коробки с яблоками № 2: %.2f кг.%n", appleBox2.getWeight());
        System.out.printf("Вес коробки с апельсинами: %.2f кг.%n", orangeBox.getWeight());

        System.out.println(appleBox1.compareTo(orangeBox)
                ? "Вес коробки № 1 с яблоками равен весу коробки с апельсинами."
                : "Вес коробки № 1 с яблоками не равен весу коробки с апельсинами.");
    }
}
