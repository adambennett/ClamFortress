package main.models.artifacts;

public abstract class AbstractArtifact {
    private String name;

    public AbstractArtifact(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public Integer multiplyFoodOnFishing() { return 1; }

    public Integer multiplyFoodOnHunting() { return 1; }

    public Integer modifyFaithInc() { return 0; }

    public Integer modifyAtk() { return 0; }

    public Integer modifyDef() { return 0; }

    public Integer modifyPopCapIncreases() { return 0; }

}
