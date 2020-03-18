package main.models.animals.sea;

public class Seal extends AbstractSeaAnimal {

    public Seal(){
        super("Seal", 120);
    }

    @Override
    public Seal clone() {
        return new Seal();
    }
}
