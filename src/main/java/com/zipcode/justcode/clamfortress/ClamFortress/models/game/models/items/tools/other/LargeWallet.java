package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.other;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class LargeWallet extends AbstractItem {
    public LargeWallet() {
        super("Large Wallet", "Increases your coin limit by 10000.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().setCoinLimit(Database.getCurrentGame().getVillage().getCoinLimit() + 10000);
    }

    @Override
    public LargeWallet clone() {
        return new LargeWallet();
    }
}
