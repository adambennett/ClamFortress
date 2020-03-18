package main.models.animals.sea;



public class Penguin extends AbstractSeaAnimal {

    public Penguin(){
        super("Penguin", 24);
    }

    @Override
    public Penguin clone() {
        return new Penguin();
    }
}
