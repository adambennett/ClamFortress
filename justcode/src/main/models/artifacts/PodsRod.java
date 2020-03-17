package main.models.artifacts;

public class PodsRod extends AbstractArtifact {

    public static final Integer fishingBoost = 2;

    public PodsRod() {
        super("Pod's Rod");
    }

    @Override
    public Integer multiplyFoodOnFishing(){
        return  fishingBoost;
    }

}
