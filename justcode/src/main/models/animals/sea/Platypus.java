package main.models.animals.sea;

public class Platypus extends AbstractSeaAnimal {

    public Platypus(){
        super("Platypus", "The platypus, sometimes referred to as the duck-billed platypus, is a semiaquatic egg-laying mammal endemic to eastern Australia, including Tasmania. The platypus is the sole living representative of its family and genus, though a number of related species appear in the fossil record.",20);
    }

    @Override
    public Platypus clone() {
        return new Platypus();
    }
}
