package main.models.items.military.weapons.guns;


public class MP5 extends AbstractGun {

    public MP5() {
        super("MP5", "Standard issue MP5.", 48, 6, 65);
    }

    @Override
    public MP5 clone() {
        return new MP5();
    }
}
