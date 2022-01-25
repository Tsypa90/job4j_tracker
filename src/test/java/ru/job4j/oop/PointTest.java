package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class PointTest extends TestCase {

    public void testDistanceExp2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        double expected = 2;
        assertEquals(rsl, expected);
    }

    public void testDistanceExp4() {
        Point a = new Point(2, 4);
        Point b = new Point(2, 8);
        double rsl = a.distance(b);
        double expected = 4;
        assertEquals(rsl, expected);
    }

    public void testDistanceExp3() {
        Point a = new Point(2, 1);
        Point b = new Point(5, 2);
        double rsl = a.distance(b);
        double expected = 3.16;
        assertEquals(rsl, expected, 0.01);
    }

    public void testDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 2, 2);
        double rsl = a.distance3d(b);
        double expected = 3;
        assertEquals(rsl, expected);
    }
}