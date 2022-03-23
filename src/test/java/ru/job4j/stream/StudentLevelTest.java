package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<StudentStream> input = new ArrayList<>();
        input.add(new StudentStream("Masha", 28));
        input.add(new StudentStream("Pety", 128));
        List<StudentStream> expected = List.of(
                new StudentStream("Pety", 128),
                new StudentStream("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<StudentStream> input = new ArrayList<>();
        input.add(null);
        List<StudentStream> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<StudentStream> input = new ArrayList<>();
        input.add(null);
        input.add(new StudentStream("Pety", 28));
        List<StudentStream> expected = List.of(new StudentStream("Pety", 28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}