package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class CursedBackpack extends AbstractBackpack implements Cursed, Unique {
    public CursedBackpack() {
        super("Cursed Backpack", "Increases your inventory capacity by 600.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().getInventory().setCapacity(Database.getCurrentGame().getVillage().getInventory().getCapacity() + 600);
    }

    @Override
    public CursedBackpack clone() {
        return new CursedBackpack();
    }
}
