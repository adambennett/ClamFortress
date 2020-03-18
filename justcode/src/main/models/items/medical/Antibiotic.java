package main.models.items.medical;


public class Antibiotic extends AbstractMedicalItem {

    public Antibiotic() {
        super("Antibiotic", "A healing item.");
    }

    @Override
    public Antibiotic clone() {
        return new Antibiotic();
    }
}
