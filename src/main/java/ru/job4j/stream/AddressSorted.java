package ru.job4j.stream;

import java.util.Comparator;

public class AddressSorted implements Comparator<Address> {
    @Override
    public int compare(Address o, Address t) {
        return o.getCity().compareTo(t.getCity());
    }
}
