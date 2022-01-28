package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurname("Pavel Tsyurupa");
        student.setGroupNumber(382);
        student.setEnteredDate(new Date(107, 8, 1));
        System.out.println("ФИО студента: " + student.getNameSurname() + System.lineSeparator()
                + "Номер группы: " + student.getGroupNumber() + System.lineSeparator()
                + "Дата поступления: " + student.getEnteredDate(new Date()));
    }
}
