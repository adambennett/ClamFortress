package main.models.animals.land.bears;

public class BrownBear extends Bear {

    public BrownBear() {
        super(250);
    }

    @Override
    public BrownBear clone() {
        return new BrownBear();
    }
}
