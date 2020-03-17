package main.models.artifacts;

public class PodsRod extends AbstractArtifact {

    public static final  Integer fishingBoost = 2;

    public PodsRod() {
        super("Pod's Rod");
    }

    public Integer modifyFoodOnFishing(){
        return  fishingBoost;
    }

}
