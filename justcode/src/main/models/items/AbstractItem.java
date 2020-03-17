package main.models.items;

public abstract class AbstractItem {

    private String name;
    private String desc;

    public AbstractItem(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() { return desc; }

    @Override
    public boolean equals(Object item) {
        if (item instanceof AbstractItem) {
            return (this.name.equals(((AbstractItem) item).getName()));
        } else {
            return super.equals(item);
        }
    }
}
