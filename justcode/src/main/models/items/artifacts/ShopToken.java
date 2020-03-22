package main.models.items.artifacts;

import main.interfaces.*;

public class ShopToken extends AbstractArtifact implements Unique {

    public ShopToken() {
        super("Shop Token", "Improves the chance to encounter Merchants while Scouting.");
    }


    @Override
    public ShopToken clone() {
        return new ShopToken();
    }
}
