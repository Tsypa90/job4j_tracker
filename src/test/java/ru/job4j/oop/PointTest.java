package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class PointTest {

    @Test
    public void testDistanceWhen00To02Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        double expected = 2;
        assertEquals(rsl, expected);
    }

    @Test
    public void testDistanceWhen24To28Then4() {
        Point a = new Point(2, 4);
        Point b = new Point(2, 8);
        double rsl = a.distance(b);
        double expected = 4;
        assertEquals(rsl, expected);
    }

    @Test
    public void testDistanceWhen21To52Then3() {
        Point a = new Point(2, 1);
        Point b = new Point(5, 2);
        double rsl = a.distance(b);
        double expected = 3.16;
        assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void testDistanceWhen000To122Then3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 2, 2);
        double rsl = a.distance3d(b);
        double expected = 3;
        assertEquals(rsl, expected);
    }

    @Test
    public void testDistanceWhen215To525Then3() {
        Point a = new Point(2, 1, 5);
        Point b = new Point(5, 2, 5);
        double rsl = a.distance3d(b);
        double expected = 3.16;
        assertEquals(rsl, expected, 0.01);
    }
}