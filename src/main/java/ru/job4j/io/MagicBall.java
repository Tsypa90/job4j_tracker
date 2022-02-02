package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static String answer() {
        int answer = new Random().nextInt(3);
        String result = "Может быть";
        if (answer == 0) {
            result = "Да";
        } else if (answer == 1) {
            result = "Нет";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        System.out.println(question + " " + answer());
    }
}
