package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

public class Battlebag extends AbstractBackpack {
    public Battlebag() {
        super("Battlebag", "Improves your attack by 50. Increases your inventory capacity by 25.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 25);
    }

    @Override
    public Integer modifyAtk() {
        return 50;
    }

    @Override
    public Battlebag clone() {
        return new Battlebag();
    }
}
