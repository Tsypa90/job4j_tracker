package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book azbuka = new Book("Азбука", 80);
        Book vlastelinKoletc = new Book("Властелин колец", 1560);
        Book voinaIMir = new Book("Война и мир", 3591);
        Book cleanCode =  new Book("Clean code", 464);
        Book[] lib = new Book[4];
        lib[0] = azbuka;
        lib[1] = vlastelinKoletc;
        lib[2] = voinaIMir;
        lib[3] = cleanCode;
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        Book temp = lib[0];
        lib[0] = lib[2];
        lib[2] = temp;
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
