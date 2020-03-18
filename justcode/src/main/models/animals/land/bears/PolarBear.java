package main.models.animals.land.bears;

public class PolarBear extends AbstractBear {

    public PolarBear() {
        super("Polar Bear", 250);
    }

    @Override
    public PolarBear clone() {
        return new PolarBear();
    }
}
