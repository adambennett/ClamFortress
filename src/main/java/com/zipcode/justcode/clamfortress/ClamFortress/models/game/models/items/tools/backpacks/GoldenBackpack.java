package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public class GoldenBackpack extends AbstractBackpack implements Golden, Unique {
    public GoldenBackpack() {
        super("Golden Backpack", "Increases your inventory capacity by 2000. Worth 500 Coins on pickup.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 2000);
    }

    @Override
    public GoldenBackpack clone() {
        return new GoldenBackpack();
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }
}
