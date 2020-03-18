package main.encounters.merchant;

import main.encounters.*;
import main.models.*;

public abstract class AbstractMerchant extends AbstractEncounter {

    @Override
    public void runEncounter() {
        Game.getVillage().addMerchant(this);
    }

}
