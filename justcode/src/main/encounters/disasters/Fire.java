package main.encounters.disasters;

import main.models.*;

public class Fire extends AbstractDisaster {
    public Fire(int turns) {
        super("Fire", "A devastating fire", turns);
    }

    @Override
    public void runEncounter() {
        Game.getVillage().addDisaster(this);
    }

    @Override
    public String toString() {
        return "A Fire ravaging your village for " + this.turnsActive + " turns!";
    }

    @Override
    public Fire clone() {
        return new Fire(this.turnsActive);
    }
}
