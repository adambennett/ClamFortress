package main.models.animals.tundra;

public class Moose extends AbstractTundraAnimal {


    public Moose() {
        super("Moose", 345);
    }

    @Override
    public Moose clone() {
        return new Moose();
    }
}
