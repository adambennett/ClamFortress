package main.models.items.military.weapons.guns;


public class AK47 extends AbstractGun {

    public AK47() {
        super("AK47", "Standard issue M16.", 100, 100, 44);
    }

    @Override
    public AK47 clone() {
        return new AK47();
    }
}
