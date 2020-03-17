package main.models.animals.desert;

public class Lizard extends DesertAnimal {

    public Lizard() {
        super(15);
    }

    @Override
    public Lizard clone() {
        return new Lizard();
    }
}
