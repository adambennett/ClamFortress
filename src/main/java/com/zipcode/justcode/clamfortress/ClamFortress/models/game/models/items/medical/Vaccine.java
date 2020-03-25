package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.medical;

public class Vaccine extends AbstractMedicalItem {
    public Vaccine() {
        super("Vaccine", "Helps prevent disease.");
    }

    @Override
    public Vaccine clone() {
        return new Vaccine();
    }
}
