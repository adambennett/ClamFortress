package main.models.items.military.weapons.future;

public class GooRifle extends AbstractGooGun {

    public GooRifle() {
        super("Goo Rifle", "As long as you got the goo, we got the goo.", 0, 500, 55);
    }

    @Override
    public GooRifle clone() {
        return new GooRifle();
    }
}
