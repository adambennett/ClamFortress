package main.models.animals.sea;

public class Fish extends AbstractSeaAnimal {

    public Fish(){
        super(20);
    }

    @Override
    public Fish clone() {
        return new Fish();
    }
}
