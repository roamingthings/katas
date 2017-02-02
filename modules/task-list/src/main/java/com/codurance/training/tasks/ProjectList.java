package com.codurance.training.tasks;

import java.util.*;

import static java.lang.Long.valueOf;

public class ProjectList {

    final List<Project> projects = new ArrayList<>();


    Project getProjectByName(String projectName) {
        return projects.stream().filter(p -> p.getName().equals(projectName)).findFirst().get();
    }

    void add(String name) {
        projects.add(new Project(name));
    }


    Task getTaskById(String idString) {
        long id = valueOf(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    return task;
                }
            }
        }
        return null;
    }

    public List<Project> getProjects() {
        return projects;
    }

}