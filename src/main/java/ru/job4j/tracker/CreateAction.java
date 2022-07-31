package ru.job4j.tracker;

import java.awt.*;
import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name, "desc");
        store.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
