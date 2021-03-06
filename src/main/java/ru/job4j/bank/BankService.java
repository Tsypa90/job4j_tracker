package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковских сервисов
 * добавление банковского аккаунта и счета, а также перевод дс с одного на другой
 * @author Pavel Tsyurupa
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется коллекцией типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя банковского сервиса
     * Добалвяет пользователя если данного пользователя еще нет в системе
     * @param user пользователь банковского сервиса c
     *             переменными номер паспорта и именем.
     * @see User#User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает номер паспорта пользователя и номер счёта.
     * Если пользователя с таким паспортом найден, то добавляем
     * номер счёта если его нет.
     * @param passport номер паспорта пользователя
     * @param account счет пользователя с парамертрами
     *                номер счёта и баланс счёта
     * @see Account#Account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод описывает поиск пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return пользователя банковского сервиса
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод описывает поиск счёта пользователя по номеру счёта пользователя
     * @param passport номер паспорта пользователя
     * @param requisite номер счёта пользователя
     * @return возвращает счёт пользователя банкового сервиса
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод описывает перевод дс с одного счёта на другой
     * при наличии данных счётов у пользователя и достаточных дс на них
     * @param srcPassport номер паспорта пользователя списываемого счёта
     * @param srcRequisite номер списываемого счёта пользователя
     * @param destPassport номер паспорта пользователя куда отправляются дс
     * @param destRequisite номер счёта пользователя куда отправляются дс
     * @param amount колличество переводимых дс
     * @return возвращает успешна выполнена операция или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (accountSrc.isPresent() && accountDest.isPresent() && (accountSrc).get().getBalance() >= amount) {
            (accountSrc).get().setBalance((accountSrc).get().getBalance() - amount);
            (accountDest).get().setBalance((accountDest).get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}