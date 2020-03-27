package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class CorpseBag extends AbstractBackpack {
    public CorpseBag() {
        super("Corpse Bag", "When you kill an enemy, increases your inventory capacity by 1.");
    }

    @Override
    public void onEnemyDeath() {
        Database.getCurrentGame().getVillage().getInventory().setCapacity(Database.getCurrentGame().getVillage().getInventory().getCapacity() + 1);
    }

    @Override
    public CorpseBag clone() {
        return new CorpseBag();
    }
}
