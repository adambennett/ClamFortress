package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.other;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;

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
