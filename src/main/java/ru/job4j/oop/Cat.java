package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println(this.name + " eat " + this.food);
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        peppy.eat("kotleta");
        peppy.giveNick("peppy");
        peppy.show();
        Cat sparky = new Cat();
        sparky.eat("fish");
        sparky.giveNick("sparky");
        sparky.show();
    }
}
