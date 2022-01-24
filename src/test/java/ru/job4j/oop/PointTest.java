package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class PointTest extends TestCase {

    public void testDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        double expected = 2;
        assertEquals(rsl, expected);
    }

    public void testDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 2, 2);
        double rsl = a.distance3d(b);
        double expected = 3;
        assertEquals(rsl, expected);
    }
}