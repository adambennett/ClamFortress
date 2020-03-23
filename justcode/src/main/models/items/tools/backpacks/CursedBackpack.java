package main.models.items.tools.backpacks;

import main.interfaces.*;
import main.models.*;

public class CursedBackpack extends AbstractBackpack implements Cursed, Unique {
    public CursedBackpack() {
        super("Cursed Backpack", "Increases your inventory capacity by 600.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 600);
    }

    @Override
    public CursedBackpack clone() {
        return new CursedBackpack();
    }
}
