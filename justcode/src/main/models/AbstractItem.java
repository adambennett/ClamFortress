package main.models;

public abstract class AbstractItem {

    private String name;

    public AbstractItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
