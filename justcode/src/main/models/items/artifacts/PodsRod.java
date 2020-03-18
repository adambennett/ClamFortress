package main.models.items.artifacts;

import main.interfaces.*;

public class PodsRod extends AbstractArtifact implements Unique {

    public static final Integer fishingBoost = 2;

    public PodsRod() {
        super("Pod's Rod", "Increases your fishing by 2");
    }

    @Override
    public Integer multiplyFoodOnFishing(){
        return  fishingBoost;
    }

    @Override
    public PodsRod clone() {
        return new PodsRod();
    }

}
