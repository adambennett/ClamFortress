package main.models.animals.desert;

public class Camel extends AbstractDesertAnimal {

    public Camel() {
        super("Camel", 175);
    }

    @Override
    public Camel clone() {
        return new Camel();
    }
}
