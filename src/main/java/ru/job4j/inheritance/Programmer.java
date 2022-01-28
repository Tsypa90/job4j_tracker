package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String program;

    public Programmer(String name, String surname, String education, String birthday, String specialty, String program) {
        super(name, surname, education, birthday, specialty);
        this.program = program;
    }

    public String whatMake() {
        return program;
    }
}
