package main.models.animals.land.bears;

public class Pizzly extends AbstractBear {

    public Pizzly() {
        super(250);
    }

    @Override
    public Pizzly clone() {
        return new Pizzly();
    }
}
