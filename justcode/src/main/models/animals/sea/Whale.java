package main.models.animals.sea;

public class Whale extends AbstractSeaAnimal {

    public Whale(){
        super(450);
    }

    @Override
    public Whale clone() {
        return new Whale();
    }
}
