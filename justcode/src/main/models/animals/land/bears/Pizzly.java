package main.models.animals.land.bears;

public class Pizzly extends AbstractBear {

    public Pizzly() {
        super("Pizzly", "A grizzly–polar bear hybrid is a rare ursid hybrid that has occurred both in captivity and in the wild. In 2006, the occurrence of this hybrid in nature was confirmed by testing the DNA of a unique-looking bear that had been shot near Sachs Harbour, Northwest Territories on Banks Island in the Canadian Arctic.", 250);
    }

    @Override
    public Pizzly clone() {
        return new Pizzly();
    }
}
