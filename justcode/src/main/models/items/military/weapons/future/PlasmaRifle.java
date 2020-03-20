package main.models.items.military.weapons.future;

public class PlasmaRifle extends AbstractFutureGun {

    public PlasmaRifle() {
        super("Plasma Rifle", "How does this thing work anyway?", 1000, 100, 90);
    }

    @Override
    public PlasmaRifle clone() {
        return new PlasmaRifle();
    }
}
