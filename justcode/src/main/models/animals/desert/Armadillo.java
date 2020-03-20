package main.models.animals.desert;

public class Armadillo extends AbstractDesertAnimal {

    public Armadillo() {
        super("Armadillo", "Armadillos are New World placental mammals in the order Cingulata. The Chlamyphoridae and Dasypodidae are the only surviving families in the order, which is part of the superorder Xenarthra, along with the anteaters and sloths.",10);
    }

    @Override
    public Armadillo clone() {
        return new Armadillo();
    }
}
