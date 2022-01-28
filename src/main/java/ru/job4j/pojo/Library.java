package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book azbuka = new Book("Азбука", 80);
        Book vlastelinKoletc = new Book("Властелин колец", 1560);
        Book voinaIMir = new Book("Война и мир", 3591);
        Book cleanCode =  new Book("Clean code", 464);
        String[] lib = new String[4];
        lib[0] = azbuka.getName();
        lib[1] = vlastelinKoletc.getName();
        lib[2] = voinaIMir.getName();
        lib[3] = cleanCode.getName();
        for (int index = 0; index < lib.length; index++) {
            System.out.println(lib[index]);
        }
        String temp = lib[0];
        lib[0] = lib[2];
        lib[2] = temp;
        for (int index = 0; index < lib.length; index++) {
            System.out.println(lib[index]);
        }
        for (int index = 0; index < lib.length; index++) {
            if (lib[index] == "Clean code") {
                System.out.println(lib[index]);
            }
        }
    }
}
