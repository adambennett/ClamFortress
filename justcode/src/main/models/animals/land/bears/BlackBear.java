package main.models.animals.land.bears;

public class BlackBear extends AbstractBear {

    public BlackBear() {
        super("Black Bear", 250);
    }

    @Override
    public BlackBear clone() {
        return new BlackBear();
    }
}
