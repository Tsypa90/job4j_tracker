package ru.job4j.oop;

public class Error {
    private boolean active;

    private int status;

    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Сообщение: " + massage);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 404, "Синий экран");
        error.printInfo();
        Error errorik = new Error(false, 344, "Don't know");
        errorik.printInfo();
        Error errodefault = new Error();
        errodefault.printInfo();
    }

}
