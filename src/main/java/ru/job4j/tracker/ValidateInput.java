package ru.job4j.tracker;

public class ValidateInput implements Input {
    private Output out;
    private final Input in;

    public ValidateInput(Input input, Output out) {
        this.in = input;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        String value = null;
        do {
            try {
                value = in.askStr(question);
                if (value.isEmpty()) {
                    out.println("Please enter validate data again.");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (value.isEmpty());
        return value;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
