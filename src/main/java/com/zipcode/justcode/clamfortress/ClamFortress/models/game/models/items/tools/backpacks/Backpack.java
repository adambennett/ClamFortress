package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Backpack extends AbstractBackpack {
    public Backpack() {
        super("Backpack", "Increases your inventory capacity by 100.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().getInventory().setCapacity(Database.getCurrentGame().getVillage().getInventory().getCapacity() + 100);
    }

    @Override
    public Backpack clone() {
        return new Backpack();
    }
}
