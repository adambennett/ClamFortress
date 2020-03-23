package main.models.items.artifacts;

import main.interfaces.*;
import main.models.managers.*;

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
