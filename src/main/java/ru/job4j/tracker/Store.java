package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public interface Store {
    Item add(Item item) throws SQLException;

    boolean replace(int id, Item item);

    boolean delete(int id);

    void deleteAll();

    List<Item> findAll();

    void findAllByReact(Observe<Item> observe);

    List<Item> findByName(String key);

    Item findById(int id);
}
