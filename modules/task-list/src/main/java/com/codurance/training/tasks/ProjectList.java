package com.codurance.training.tasks;

import java.util.*;

import static java.lang.Long.valueOf;

public class ProjectList {

    final List<Project> projects = new ArrayList<>();
    private long lastId = 0;

    Project getProjectByName(String projectName) {
        Optional<Project> project = projects
            .stream()
            .filter(p -> p.getName().equals(projectName))
            .findFirst();

        return project.orElseThrow(ProjectNotFoundException::new);
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

        throw new TaskNotFoundException();
    }

    List<Project> getProjects() {
        return projects;
    }

    void setDeadline(String idString, String date) {
        Task task = getTaskById(idString);
        task.setDeadline(date);
    }

    public void setDone(String idString, boolean done) {
        Task task = getTaskById(idString);
        task.setDone(done);
    }

    public void addTask(String projectName, String description) {
        Project project = getProjectByName(projectName);
        project.addTask(new Task(nextId(), description, false));
    }

    private long nextId() {
        return ++lastId;
    }

    @Override
    public String toString() {
        String output = "";
        for (Project project : getProjects()) {
            output += project.getName() + "\n";
            for (Task task : project.getTasks()) {
                output += task.toString();
            }
            output += "\n";
        }
        return output;
    }
}