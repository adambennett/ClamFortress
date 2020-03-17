package main.models.animals.land.bears;

public class BlackBear extends Bear {

    public BlackBear() {
        super(250);
    }

    @Override
    public BlackBear clone() {
        return new BlackBear();
    }
}
