package main.models.items.artifacts;

public class MoonShield extends AbstractArtifact {

    private static final Integer defBoost = 15;

    public MoonShield() {
        super("Moon Shield");
    }

    @Override
    public Integer modifyDef() {
        return defBoost;
    }
}
