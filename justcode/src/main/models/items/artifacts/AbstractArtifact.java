package main.models.items.artifacts;

import main.models.items.*;

public abstract class AbstractArtifact extends AbstractItem {

    public AbstractArtifact(String name, String desc) { super(name, desc); }

    public Integer multiplyFoodOnFishing() { return 1; }

    public Integer multiplyFoodOnHunting() { return 1; }

    public Integer modifyFaithInc() { return 0; }

    public Integer modifyAtk() { return 0; }

    public Integer modifyDef() { return 0; }

    public Integer modifyPopCapIncreases() { return 0; }

}
