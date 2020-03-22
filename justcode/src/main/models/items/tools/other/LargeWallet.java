package main.models.items.tools.other;

import main.models.*;
import main.models.items.*;

public class LargeWallet extends AbstractItem {
    public LargeWallet() {
        super("Large Wallet", "Increases your coin limit by 10000.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().setCoinLimit(Game.getVillage().getCoinLimit() + 10000);
    }

    @Override
    public LargeWallet clone() {
        return new LargeWallet();
    }
}
