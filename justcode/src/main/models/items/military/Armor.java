package main.models.items.military;

import main.models.items.*;
import main.models.resources.*;

public class Armor extends AbstractMilitaryItem {
    public Armor() {
        super("Armor", "Strong armor that improves your defense.");
    }

    @Override
    public Armor clone() {
        return new Armor();
    }
}
