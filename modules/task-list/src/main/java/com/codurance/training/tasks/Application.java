package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class Application implements Runnable {
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;
    private final ProjectList projectList;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new Application(in, out).run();
    }

    public Application(BufferedReader reader, PrintWriter writer) {
        in = reader;
        out = writer;
        projectList = new ProjectList();
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1]);
                break;
            case "uncheck":
                uncheck(commandRest[1]);
                break;
            case "deadline":
                deadline(commandRest[1]);
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void deadline(String argumentString) {
        String[] arguments = argumentString.split(" ");
        String taskId = arguments[0];
        String date = arguments[1];

        try {
            projectList.setDeadline(taskId, date);

        } catch (TaskNotFoundException e) {
            out.printf("Could not find a task with an ID of %s.", taskId);
            out.println();
        }
    }

    private void show() {
        out.print(projectList.toString());
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            projectList.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addTask(String projectName, String description) {
        try {
            projectList.addTask(projectName, description);
        } catch (ProjectNotFoundException e) {
            out.printf("Could not find a project with the name \"%s\".", projectName);
            out.println();
        }
    }

    private void check(String taskId) {
        setDone(taskId, true);
    }

    private void uncheck(String taskId) {
        setDone(taskId, false);
    }

    private void setDone(String taskId, boolean done) {
        try {
            projectList.setDone(taskId, done);
        } catch (TaskNotFoundException e) {
            out.printf("Could not find a task with an ID of %s.", taskId);
            out.println();
        }
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}