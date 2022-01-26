package ru.job4j.oop;

public class Builder extends Engineer {
    private String building;

    public Builder(String name, String surname, String education, String birthday, String specialty, String program, String building) {
        super(name, surname, education, birthday, specialty);
        this.building = building;
    }

    public String heMake() {
        return building;
    }
}
