package main.models.items.artifacts;

import main.interfaces.*;
import main.models.managers.*;

public class TrainingToken extends AbstractArtifact implements Unique {

    public TrainingToken() {
        super("Training Token", "Reduces the cost of training by 100 Coins.");
    }

    @Override
    public void onObtain() {
        GameManager.getInstance().setTrainingCost(GameManager.getInstance().getTrainingCost() - 100);
    }

    @Override
    public TrainingToken clone() {
        return new TrainingToken();
    }
}
