package main.models.animals.sea;

public class Whale extends AbstractSeaAnimal {

    public Whale(){
        super("Whale", 450);
    }

    @Override
    public Whale clone() {
        return new Whale();
    }
}
