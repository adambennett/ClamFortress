package main.models.items.tools.backpacks;

import main.models.*;

public class Backpack extends AbstractBackpack {
    public Backpack() {
        super("Backpack", "Increases your inventory capacity by 100.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 100);
    }

    @Override
    public Backpack clone() {
        return new Backpack();
    }
}
