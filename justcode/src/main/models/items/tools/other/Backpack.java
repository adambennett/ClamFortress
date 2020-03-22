package main.models.items.tools.other;

import main.models.*;
import main.models.items.*;

public class Backpack extends AbstractItem {
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
