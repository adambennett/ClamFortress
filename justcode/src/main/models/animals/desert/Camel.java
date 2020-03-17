package main.models.animals.desert;

public class Camel extends DesertAnimal {

    public Camel() {
        super(175);
    }

    @Override
    public Camel clone() {
        return new Camel();
    }
}
