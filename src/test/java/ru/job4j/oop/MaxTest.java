package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxTest extends TestCase {

    public void testMax() {
        Max max = new Max();
        int result = Max.max(1, 5);
        int expected = 5;
        Assert.assertEquals(result,
                expected);
    }

    public void testMaxThird() {
        Max max = new Max();
        int result = Max.max(1, 5, 6);
        int expected = 6;
        Assert.assertEquals(result,
                expected);
    }

    public void testMaxFour() {
        Max max = new Max();
        int result = Max.max(1, 5, 6, 8);
        int expected = 8;
        Assert.assertEquals(result,
                expected);
    }
}