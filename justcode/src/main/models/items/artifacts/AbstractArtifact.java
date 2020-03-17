package main.models.items.artifacts;

import main.models.items.*;

public abstract class AbstractArtifact extends AbstractItem {
    private String name;

    public AbstractArtifact(String name) { super(name); }

    public Integer multiplyFoodOnFishing() { return 1; }

    public Integer multiplyFoodOnHunting() { return 1; }

    public String getName() {
        return name;
    }

    public Integer modifyFaithInc() { return 0; }

    public Integer modifyAtk() { return 0; }

    public Integer modifyDef() { return 0; }

    public Integer modifyPopCapIncreases() { return 0; }
}
