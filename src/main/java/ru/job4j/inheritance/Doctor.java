package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String doctorProfile;

    public Doctor(String name, String surname, String education, String birthday, String doctorProfile) {
        super(name, surname, education, birthday);
        this.doctorProfile = doctorProfile;
    }

    public String getDoctorProfile() {
        return doctorProfile;
    }
}