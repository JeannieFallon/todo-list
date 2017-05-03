package org.launchcode.models;

/**
 * Created by jeannie on 5/2/17.
 */
public class Task {

    private String name;
    private String description;
    private int id;

    public Task() {
    }

    public Task(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

}
