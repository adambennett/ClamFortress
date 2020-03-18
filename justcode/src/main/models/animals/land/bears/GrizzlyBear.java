package main.models.animals.land.bears;

public class GrizzlyBear extends AbstractBear {

    public GrizzlyBear() {
        super(250);
    }

    @Override
    public GrizzlyBear clone() {
        return new GrizzlyBear();
    }
}
