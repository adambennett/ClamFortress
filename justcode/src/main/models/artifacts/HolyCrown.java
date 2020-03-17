package main.models.artifacts;

public class HolyCrown extends AbstractArtifact {

    private static final Integer faithBonus = 15;

    public HolyCrown() {
        super("Holy Crown");
    }

    @Override
    public Integer modifyFaithInc() { return faithBonus; }
}
