package main.models.animals.tundra;

public class Moose extends AbstractTundraAnimal {


    public Moose() {
        super("Moose", "The moose or elk, Alces alces, is a member of the New World deer subfamily and is the largest and heaviest extant species in the deer family. Moose are distinguished by the broad, palmate antlers of the males; other members of the deer family have antlers with a dendritic configuration.",345);
    }

    @Override
    public Moose clone() {
        return new Moose();
    }
}
