package main.models.buildings.abstracts;

public abstract class AbstractFaithBuilding extends AbstractBuilding {

    protected Integer prayBonus;

    public AbstractFaithBuilding(String name, int faithBonus, int popCapInc) {
        super(name, popCapInc);
        this.prayBonus = faithBonus;
    }

    public Integer getPrayBonus() {
        return prayBonus;
    }
}
