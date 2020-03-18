package main.models.animals.land.bears;

public class CaveBear extends AbstractBear {

    public CaveBear() {
        super(250);
    }

    @Override
    public CaveBear clone() {
        return new CaveBear();
    }
}
