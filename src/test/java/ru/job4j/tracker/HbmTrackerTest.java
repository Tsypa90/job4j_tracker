package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddTwiceAndGetAll() {
        List<Item> items = List.of(new Item("first", "first"),
                new Item("second", "second"));
        HbmTracker tracker = new HbmTracker();
        items.forEach(tracker::add);
        var rsl = tracker.findAll();
        assertEquals(rsl, items);
    }

    @Test
    public void whenAddThenUpdateAndTrue() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        tracker.add(one);
        one.setName("test");
        boolean rsl = tracker.replace(one.getId(), one);
        assertTrue(rsl);
    }

    @Test
    public void whenNoAddAndUpdateThenFalse() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        one.setName("test");
        boolean rsl = tracker.replace(one.getId(), one);
        assertFalse(rsl);
    }

    @Test
    public void whenAddThenDeleteAndTrue() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        tracker.add(one);
        boolean rsl = tracker.delete(one.getId());
        assertTrue(rsl);
    }

    @Test
    public void whenAddThenUpdateAndNameEqualsTrue() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        tracker.add(one);
        one.setName("test");
        tracker.replace(one.getId(), one);
        var rsl = tracker.findById(one.getId());
        assertEquals(rsl.getName(), "test");
    }

    @Test
    public void whenNoAddThenDeleteAndFalse() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        boolean rsl = tracker.delete(one.getId());
        assertFalse(rsl);
    }

    @Test
    public void whenAddThenDeleteAll() {
        List<Item> items = List.of(new Item("first", "first"),
                new Item("second", "second"));
        HbmTracker tracker = new HbmTracker();
        items.forEach(tracker::add);
        tracker.deleteAll();
        var rsl = tracker.findAll();
        assertTrue(rsl.isEmpty());
    }

    @Test
    public void whenFindByName() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        tracker.add(one);
        var rsl = tracker.findByName("first");
        assertEquals(rsl.get(0).getName(), "first");
    }

    @Test
    public void whenFindById() {
        Item one = new Item("first", "first");
        HbmTracker tracker = new HbmTracker();
        tracker.add(one);
        var rsl = tracker.findById(one.getId());
        assertEquals(rsl, one);
    }
}