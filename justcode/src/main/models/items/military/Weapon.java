package main.models.items.military;

import main.models.items.*;
import main.models.resources.*;

public class Weapon extends AbstractMilitaryItem {
    public Weapon() {
        super("Weapon", "Strong weapon that improves your attack.");
    }

    @Override
    public Weapon clone() {
        return new Weapon();
    }
}
