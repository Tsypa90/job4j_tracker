package ru.job4j.tracker;

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
    public boolean execute(Input input, SqlTracker sqlTracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        /*do {
            if (name.isEmpty()) {
                System.out.println("Name is empty!");
                name = input.askStr("Enter name: ");
            }
        } while (name.isEmpty());*/
        Item item = new Item(name);
        sqlTracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
