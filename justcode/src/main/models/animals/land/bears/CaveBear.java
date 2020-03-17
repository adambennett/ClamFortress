package main.models.animals.land.bears;

public class CaveBear extends Bear {

    public CaveBear() {
        super(250);
    }

    @Override
    public CaveBear clone() {
        return new CaveBear();
    }
}
