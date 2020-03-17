package main.models.artifacts;

public class AbstractArtifact {
    private String name;

    public AbstractArtifact(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public Integer modifyFaithInc() { return 0; }

    public Integer modifyAtk() { return 0; }

    public Integer modifyDef() { return 0; }

}
