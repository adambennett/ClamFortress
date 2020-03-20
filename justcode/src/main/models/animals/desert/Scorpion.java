package main.models.animals.desert;

public class Scorpion extends AbstractDesertAnimal {


    public Scorpion() {
        super("Scorpion", "Scorpions are predatory arachnids of the order Scorpiones. They have eight legs and are easily recognized by the pair of grasping pedipalps and the narrow, segmented tail, often carried in a characteristic forward curve over the back, ending with a venomous stinger.", 5);
    }

    @Override
    public Scorpion clone() {
        return new Scorpion();
    }
}
