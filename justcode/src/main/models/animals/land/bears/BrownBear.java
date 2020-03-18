package main.models.animals.land.bears;

public class BrownBear extends AbstractBear {

    public BrownBear() {
        super(250);
    }

    @Override
    public BrownBear clone() {
        return new BrownBear();
    }
}
