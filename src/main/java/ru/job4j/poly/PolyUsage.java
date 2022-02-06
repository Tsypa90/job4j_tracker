package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle car = new Bus();
        Vehicle train = new Train();
        Vehicle electricTrain = new Train();
        Vehicle airplane = new Airplane();
        Vehicle jet = new Airplane();

        Vehicle[] vehicles = new Vehicle[]{bus, car, train, electricTrain, airplane, jet};
        for (Vehicle a : vehicles) {
            a.move();
            a.fuel();
        }
    }

}
