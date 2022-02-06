package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void run() {
        System.out.println("Наш автобус отправляется!");
    }

    @Override
    public void pax(int pax) {
        pax = 10;
    }

    @Override
    public int refuelPrice(int fuel) {
        int price = 10;
        return fuel * price;
    }
}
