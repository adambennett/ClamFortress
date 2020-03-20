package main.models.animals.mountain;

public class MountainGoat extends AbstractMountainAnimal {

    public MountainGoat(){
        super("Mountain Goat", "The mountain goat, also known as the Rocky Mountain goat, is a hoofed mammal endemic to North America. A subalpine to alpine species, it is a sure-footed climber commonly seen on cliffs and ice.", 75);
    }

    @Override
    public MountainGoat clone() {
        return new MountainGoat();
    }
}
