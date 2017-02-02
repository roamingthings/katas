package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

class Project {

    private String name;
    private List<Task> tasks = new ArrayList<>();

    Project(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Iterable<Task> getTasks() {
        return tasks;
    }

    void addTask(Task task) {
        tasks.add(task);
    }
}
