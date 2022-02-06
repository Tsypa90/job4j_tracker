package ru.job4j.poly;

public interface Transport {
    void run();

    void pax(int pax);

    int refuelPrice(int fuel);
}
