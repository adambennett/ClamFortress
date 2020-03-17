package main.models.artifacts;

public class AwesomeArtifact extends AbstractArtifact {

    private static final Integer atkBoost = 10;
    private static final Integer defBoost = 10;
    private static final Integer faithBoost = 5;

    public AwesomeArtifact() {
        super("Awesome Artifact");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }

    @Override
    public Integer modifyDef() {
        return defBoost;
    }

    @Override
    public Integer modifyFaithInc() { return faithBoost; }
}
