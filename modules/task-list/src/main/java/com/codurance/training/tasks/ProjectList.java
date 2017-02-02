package com.codurance.training.tasks;

import java.util.*;

import static java.lang.Long.valueOf;

class ProjectList {

    private final List<Project> projects = new ArrayList<>();
    private long lastId = 0;


    void addProject(String projectName) {
        projects.add(new Project(projectName));
    }

    void addTask(String projectName, String description) {
        Project project = getProjectByName(projectName);
        project.addTask(new Task(nextId(), description, false));
    }

    void setDone(String taskId, boolean done) {
        Task task = getTaskById(taskId);
        task.setDone(done);
    }

    void setDeadline(String taskId, String date) {
        Task task = getTaskById(taskId);
        task.setDeadline(date);
    }


    private Project getProjectByName(String projectName) {
        Optional<Project> project = projects
            .stream()
            .filter(p -> p.getName().equals(projectName))
            .findFirst();

        return project.orElseThrow(ProjectNotFoundException::new);
    }

    private Task getTaskById(String idString) {
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

    private List<Project> getProjects() {
        return projects;
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