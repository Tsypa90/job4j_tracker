package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String translate = "Неизвестное слово. " + eng;
        return translate;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String eng = "Hello";
        String what = dic.engToRus(eng);
        System.out.println(what);
    }
}
