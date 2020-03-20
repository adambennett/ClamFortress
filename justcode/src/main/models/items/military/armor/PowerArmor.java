package main.models.items.military.armor;

public class PowerArmor extends AbstractArmor {

    public PowerArmor() {
        super("Power Armor", "Futuristic combat armor. Makes your villagers virtually indestructible on the battlefield. Improves your defense by 1000.");
    }

    @Override
    public Integer modifyDef() {
        return 1000;
    }

    @Override
    public PowerArmor clone() {
        return new PowerArmor();
    }
}
