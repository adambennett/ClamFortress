package main.models.animals.land.bears;

public class CaveBear extends AbstractBear {

    public CaveBear() {
        super("Cave Bear", 250);
    }

    @Override
    public CaveBear clone() {
        return new CaveBear();
    }
}
