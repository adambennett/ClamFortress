package main.models.items.medical;

import main.models.items.*;
import main.models.resources.*;

public class Vaccine extends AbstractMedicalItem {
    public Vaccine() {
        super("Vaccine", "A healing item.");
    }

    @Override
    public Vaccine clone() {
        return new Vaccine();
    }
}
