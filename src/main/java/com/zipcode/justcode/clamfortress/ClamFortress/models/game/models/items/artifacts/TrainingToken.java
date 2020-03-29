package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class TrainingToken extends AbstractArtifact implements Unique {

    public TrainingToken() {
        super("Training Token", "Reduces the cost of training by 100 Coins.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().gameManager.setTrainingCost(Database.getCurrentGame().gameManager.getTrainingCost() - 100);
    }

    @Override
    public TrainingToken clone() {
        return new TrainingToken();
    }
}
