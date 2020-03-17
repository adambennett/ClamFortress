package main.models.animals.mountain;

public class Cougar extends MountainAnimal {
    @Override
    public Cougar clone() {
        return new Cougar();
    }
}
