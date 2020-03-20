package main.models.items.military.weapons.guns;


public class M16 extends AbstractGun {

    public M16() {
        super("M16", "Standard issue M16.", 36, 32, 75);
    }

    @Override
    public M16 clone() {
        return new M16();
    }
}
