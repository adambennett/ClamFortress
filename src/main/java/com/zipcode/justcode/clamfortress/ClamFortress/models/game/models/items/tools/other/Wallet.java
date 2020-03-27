package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.other;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Wallet extends AbstractItem {
    public Wallet() {
        super("Wallet", "Increases your coin limit by 1000.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().setCoinLimit(Database.getCurrentGame().getVillage().getCoinLimit() + 1000);
    }

    @Override
    public Wallet clone() {
        return new Wallet();
    }
}
