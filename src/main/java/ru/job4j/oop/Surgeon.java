package ru.job4j.oop;

import ru.job4j.inheritance.Doctor;

public class Surgeon extends Doctor {
    private String diagnosis;

    public Surgeon(String name, String surname, String education, String birthday, String doctorProfile, String diagnosis) {
        super(name, surname, education, birthday, doctorProfile);
        this.diagnosis = diagnosis;
    }

    public String diagnosisHealth() {
        return diagnosis;
    }
}
