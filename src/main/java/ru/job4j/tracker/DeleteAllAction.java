package ru.job4j.tracker;

public class DeleteAllAction implements UserAction {
    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete item ===");
        store.deleteAll();
        out.println("Заявки удалены успешно.");
        return true;
    }
}
