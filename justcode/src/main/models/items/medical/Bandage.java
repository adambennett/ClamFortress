package main.models.items.medical;

import main.models.items.*;
import main.models.resources.*;

public class Bandage extends AbstractMedicalItem {
    public Bandage() {
        super("Bandage", "Improves Healing.");
    }

    @Override
    public Bandage clone() {
        return new Bandage();
    }
}
