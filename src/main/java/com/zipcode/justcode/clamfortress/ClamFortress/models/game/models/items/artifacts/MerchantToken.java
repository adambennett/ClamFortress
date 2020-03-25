package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;

public class MerchantToken extends AbstractArtifact implements Unique {

    public MerchantToken() {
        super("Merchant Token", "Merchants will, on average, offer more items to purchase.");
    }

    @Override
    public void onObtain() {
        GameManager.getInstance().setMerchantItems(GameManager.getInstance().getMerchantItems() + 2);
    }

    @Override
    public MerchantToken clone() {
        return new MerchantToken();
    }
}
