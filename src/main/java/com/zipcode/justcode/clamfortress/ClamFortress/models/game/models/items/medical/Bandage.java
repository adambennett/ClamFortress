package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.medical;

public class Bandage extends AbstractMedicalItem {
    public Bandage() {
        super("Bandage", "Improves Healing.");
    }

    @Override
    public Bandage clone() {
        return new Bandage();
    }
}
