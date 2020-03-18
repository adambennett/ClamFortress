package main.models.items;


import main.models.*;


import java.util.*;

public abstract class AbstractItem extends GameObject {

    private String desc;

    public AbstractItem(String name, String desc) {
        super(name);
        this.desc = desc;
    }

    // Getters
    public String getDesc() { return desc; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractItem)) return false;
        if (!super.equals(o)) return false;
        AbstractItem that = (AbstractItem) o;
        return Objects.equals(getDesc(), that.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDesc());
    }

    @Override
    public abstract AbstractItem clone();
}
