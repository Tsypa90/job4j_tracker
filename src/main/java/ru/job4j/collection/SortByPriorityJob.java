package ru.job4j.collection;

import java.util.Comparator;

public class SortByPriorityJob implements Comparator<Job> {
    @Override
    public int compare(Job job, Job t1) {
        return Integer.compare(job.getPriority(), t1.getPriority());
    }
}
