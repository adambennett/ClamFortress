package main.models.animals.land.bears;

public class PolarBear extends AbstractBear {

    public PolarBear() {
        super("Polar Bear", "The polar bear is a hypercarnivorous bear whose native range lies largely within the Arctic Circle, encompassing the Arctic Ocean, its surrounding seas and surrounding land masses. It is a large bear, approximately the same size as the omnivorous Kodiak bear.",250);
    }

    @Override
    public PolarBear clone() {
        return new PolarBear();
    }
}
