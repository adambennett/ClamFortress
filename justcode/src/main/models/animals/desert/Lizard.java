package main.models.animals.desert;

public class Lizard extends DesertAnimal {
    @Override
    public Lizard clone() {
        return new Lizard();
    }
}
