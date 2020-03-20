package main.models.items.military.weapons.guns;


public class SCAR extends AbstractGun {

    public SCAR() {
        super("SCAR-H", "Standard issue SCAR-H.", 36, 48, 70);
    }

    @Override
    public SCAR clone() {
        return new SCAR();
    }
}
