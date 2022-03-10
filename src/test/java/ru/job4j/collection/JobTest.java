package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {
    @Test
    public void whenComparatorSortByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Pavel", 2));
        jobs.add(new Job("Andrey", 1));
        jobs.add(new Job("Olga", 3));
        jobs.add(new Job("Boris", 4));
        Collections.sort(jobs, new SortByNameJob());
        List<Job> expected = new ArrayList<>(Arrays.asList(
                new Job("Andrey", 1),
                new Job("Boris", 4),
                new Job("Olga", 3),
                new Job("Pavel", 2)));
        assertThat(jobs, is(expected));
    }
    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Pavel", 2));
        jobs.add(new Job("Andrey", 1));
        jobs.add(new Job("Olga", 3));
        jobs.add(new Job("Boris", 4));
        Collections.sort(jobs, new DescByNameJob());
        List<Job> expected = new ArrayList<>(Arrays.asList(
                new Job("Pavel", 2),
                new Job("Olga", 3),
                new Job("Boris", 4),
                new Job("Andrey", 1)));
        assertThat(jobs, is(expected));
    }
    @Test
    public void whenComparatorSortByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Pavel", 2));
        jobs.add(new Job("Andrey", 1));
        jobs.add(new Job("Olga", 3));
        jobs.add(new Job("Boris", 4));
        Collections.sort(jobs, new SortByPriorityJob());
        List<Job> expected = new ArrayList<>(Arrays.asList(
                new Job("Andrey", 1),
                new Job("Pavel", 2),
                new Job("Olga", 3),
                new Job("Boris", 4)));
        assertThat(jobs, is(expected));
    }
    @Test
    public void whenComparatorDesctByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Pavel", 2));
        jobs.add(new Job("Andrey", 1));
        jobs.add(new Job("Olga", 3));
        jobs.add(new Job("Boris", 4));
        Collections.sort(jobs, new DescByPriorityJob());
        List<Job> expected = new ArrayList<>(Arrays.asList(
                new Job("Boris", 4),
                new Job("Olga", 3),
                new Job("Pavel", 2),
                new Job("Andrey", 1)));
        assertThat(jobs, is(expected));
    }
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Olga", 2),
                new Job("Andrey", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    @Test
    public void whenCompatorByDescNameAndPrority() {
        Comparator<Job> cmpNamePriority = new DescByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Timur", 0),
                new Job("Pavel", 2)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new DescByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Pavel", 0),
                new Job("Pavel", 2)
        );
        assertThat(rsl, lessThan(0));
    }

}