package main.models.items.military.armor;

public class BulletproofVest extends AbstractArmor {

    public BulletproofVest() {
        super("Bulletproof Vest", "Improves your defense by 500. Give your villagers the ability to take a bullet and live to tell the tale.");
    }

    @Override
    public Integer modifyDef() {
        return 500;
    }

    @Override
    public BulletproofVest clone() {
        return new BulletproofVest();
    }
}
