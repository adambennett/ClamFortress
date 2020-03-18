package main.models.animals.mountain;

public class MountainHare extends AbstractMountainAnimal {

    public MountainHare(){
        super("Mountain Hare", 8);
    }

    @Override
    public MountainHare clone() {
        return new MountainHare();
    }
}
