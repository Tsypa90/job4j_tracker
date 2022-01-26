package ru.job4j.oop;

public class Dentist extends Doctor {
    private String teath;

    public Dentist(String name, String surname, String education, String birthday, String doctorProfile, String teeth) {
        super(name, surname, education, birthday, doctorProfile);
        this.teath = teeth;
    }

    public String treat() {
        return teath;
    }
}
