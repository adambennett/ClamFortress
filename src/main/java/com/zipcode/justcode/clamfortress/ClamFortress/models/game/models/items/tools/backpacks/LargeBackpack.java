package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class LargeBackpack extends AbstractBackpack implements Unique {
    public LargeBackpack() {
        super("Large Backpack", "Increases your inventory capacity by 5000.");
    }


    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().getInventory().setCapacity(Database.getCurrentGame().getVillage().getInventory().getCapacity() + 5000);
    }

    @Override
    public LargeBackpack clone() {
        return new LargeBackpack();
    }
}
