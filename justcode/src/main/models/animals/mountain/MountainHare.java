package main.models.animals.mountain;

public class MountainHare extends MountainAnimal {

    public MountainHare(){
        super(8);
    }

    @Override
    public MountainHare clone() {
        return new MountainHare();
    }
}
