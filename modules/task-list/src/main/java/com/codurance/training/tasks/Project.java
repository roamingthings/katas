package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private List<Task> tasks = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iterable<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
