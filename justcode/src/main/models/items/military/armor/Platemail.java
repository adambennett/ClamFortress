package main.models.items.military.armor;

public class Platemail extends AbstractArmor {

    public Platemail() {
        super("Plate Mail", "Improves your defense by 225. Battle-tested plate mail. Safeguards your citizens in battle.");
    }

    @Override
    public Integer modifyDef() {
        return 225;
    }

    @Override
    public Platemail clone() {
        return new Platemail();
    }
}
