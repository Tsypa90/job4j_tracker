package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateManyAction implements UserAction {
    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new items";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("=== Create new Items ===");
        String name = input.askStr("Enter name: ");
        int amount = input.askInt("Enter amount: ");
        for (int i = 1; i <= amount; i++) {
            store.add(new Item(name + i, "desc"));
        }
        out.println("Заявки добавлены");
        return true;
    }
}
