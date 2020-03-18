package main.models.animals.mountain;

public class MountainGoat extends AbstractMountainAnimal {

    public MountainGoat(){
        super(75);
    }

    @Override
    public MountainGoat clone() {
        return new MountainGoat();
    }
}
