package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - Ездит по дорогам.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " - Заправляется бензином.");
    }
}
