package main.models.animals.sea;

public class Fish extends SeaAnimal {

    public Fish(){
        super(20);
    }

    @Override
    public Fish clone() {
        return new Fish();
    }
}
