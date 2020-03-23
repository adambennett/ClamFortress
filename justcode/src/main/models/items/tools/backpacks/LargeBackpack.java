package main.models.items.tools.backpacks;

import main.interfaces.*;
import main.models.*;

public class LargeBackpack extends AbstractBackpack implements Unique {
    public LargeBackpack() {
        super("Large Backpack", "Increases your inventory capacity by 5000.");
    }


    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 5000);
    }

    @Override
    public LargeBackpack clone() {
        return new LargeBackpack();
    }
}
