package main.models.animals.sea;

public class Fish extends AbstractSeaAnimal {

    public Fish(){
        super("Fish", 20);
    }

    @Override
    public Fish clone() {
        return new Fish();
    }
}
