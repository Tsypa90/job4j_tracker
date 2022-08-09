package ru.job4j.lombok;

public class Usage {
    public static void main(String[] args) {
        Permission permission = Permission.of().id(1).name("Pavel").rules("all").rules("secret").build();
        Permission permission1 = Permission.of().id(1).name("Pavel").rules("all").rules("secret").build();
        System.out.println(permission.equals(permission1));
    }
}
