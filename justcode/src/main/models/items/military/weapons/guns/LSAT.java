package main.models.items.military.weapons.guns;


public class LSAT extends AbstractGun {

    public LSAT() {
        super("LSAT", "One big machine gun.", 200, 200, 70);
    }

    @Override
    public LSAT clone() {
        return new LSAT();
    }
}
