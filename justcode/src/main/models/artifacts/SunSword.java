package main.models.artifacts;

public class SunSword extends AbstractArtifact {

    private static final Integer atkBoost = 15;

    public SunSword() {
        super("Sun Sword");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }
}
