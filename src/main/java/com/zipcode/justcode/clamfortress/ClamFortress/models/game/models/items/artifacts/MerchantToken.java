package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class MerchantToken extends AbstractArtifact implements Unique {

    public MerchantToken() {
        super("Merchant Token", "Merchants will, on average, offer more items to purchase.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().gameManager.setMerchantItems(Database.getCurrentGame().gameManager.getMerchantItems() + 2);
    }

    @Override
    public MerchantToken clone() {
        return new MerchantToken();
    }
}
