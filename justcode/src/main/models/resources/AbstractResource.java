package main.models.resources;

public abstract class AbstractResource {

    private String name;

    public AbstractResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
