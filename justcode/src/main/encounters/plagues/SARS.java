package main.encounters.plagues;

import main.models.*;

public class SARS extends AbstractPlague {

    public SARS(int turns) {
        super("SARS", "A very terrible contagious disease. Causes several negative effects at the start of each end phase.", turns);
    }

    @Override
    public String toString() {
        return "SARS has stricken your village for " + this.turnsActive + " turns!";
    }

    @Override
    public SARS clone() {
        return new SARS(this.turnsActive);
    }
}
