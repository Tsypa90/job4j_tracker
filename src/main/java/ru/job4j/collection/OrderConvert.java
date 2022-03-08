package ru.job4j.collection;

import java.util.List;
import java.util.HashMap;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
