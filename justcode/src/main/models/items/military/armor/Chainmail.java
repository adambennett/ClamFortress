package main.models.items.military.armor;

public class Chainmail extends AbstractArmor {

    public Chainmail() {
        super("Chainmail", "Improves your defense by 50. Standard military-grade chainmail. Protects your citizens in battle.");
    }

    @Override
    public Integer modifyDef() {
        return 50;
    }

    @Override
    public Chainmail clone() {
        return new Chainmail();
    }
}
