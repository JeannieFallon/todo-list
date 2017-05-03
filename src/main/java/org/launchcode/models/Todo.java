package org.launchcode.models;

import java.util.List;

/**
 * Created by jeannie on 5/2/17.
 */
public class Todo {

    private List<Task> tasks;

    public Todo() {
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
