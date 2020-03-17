package main.models.buildings.abstracts;

import main.models.tech.*;
import main.models.tech.eras.*;

public abstract class AbstractBuilding {

    private final String name;
    private final Integer popCapInc;
    private Era eraRequired;

    public AbstractBuilding(String name, int popCapInc) {
        this.name = name;
        this.popCapInc = popCapInc;
        this.eraRequired = TechTree.getHead();
    }

    public void setEraRequired(Era era) {
        this.eraRequired = era;
    }

    public Boolean canBuild() {
        return (this.eraRequired.isBehind(TechTree.getCurrentEra()) || this.eraRequired.equals(TechTree.getCurrentEra()));
    }

    public String getName() { return name; }

    public Integer getPopCapInc() { return popCapInc; }
}
