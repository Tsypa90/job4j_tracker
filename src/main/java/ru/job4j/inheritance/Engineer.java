package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String specialty;

    public Engineer(String name, String surname, String education, String birthday, String specialty) {
        super(name, surname, education, birthday);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}
