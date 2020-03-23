package main.models.items.tools.backpacks;

import main.models.*;

public class CorpseBag extends AbstractBackpack {
    public CorpseBag() {
        super("Corpse Bag", "When you kill an enemy, increases your inventory capacity by 1.");
    }

    @Override
    public void onEnemyDeath() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 1);
    }

    @Override
    public CorpseBag clone() {
        return new CorpseBag();
    }
}
