package main.models.animals.sea;


public class Dolphin extends AbstractSeaAnimal {

    public Dolphin(){
        super("Dolphin", "Dolphin is a common name of aquatic mammals within the infraorder Cetacea. The term dolphin usually refers to the extant families Delphinidae, Platanistidae, Iniidae, and Pontoporiidae, and the extinct Lipotidae. There are 40 extant species named as dolphins.", 115);
    }

    @Override
    public Dolphin clone() {
        return new Dolphin();
    }
}
