package main.models.items.tools.backpacks;

import main.models.items.*;

public abstract class AbstractBackpack extends AbstractItem {
    public AbstractBackpack(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract AbstractBackpack clone();
}
