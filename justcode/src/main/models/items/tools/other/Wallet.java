package main.models.items.tools.other;

import main.models.*;
import main.models.items.*;

public class Wallet extends AbstractItem {
    public Wallet() {
        super("Wallet", "Increases your coin limit by 1000.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().setCoinLimit(Game.getVillage().getCoinLimit() + 1000);
    }

    @Override
    public Wallet clone() {
        return new Wallet();
    }
}
