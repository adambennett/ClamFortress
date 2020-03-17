package main.models.items;

public abstract class AbstractItem {

    private String name;

    public AbstractItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object item) {
        if (item instanceof AbstractItem) {
            return (this.name.equals(((AbstractItem) item).getName()));
        } else {
            return super.equals(item);
        }
    }
}
