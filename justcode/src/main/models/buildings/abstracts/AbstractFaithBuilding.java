package main.models.buildings.abstracts;

public abstract class AbstractFaithBuilding extends AbstractBuilding {

    protected Integer prayBonus;

    public AbstractFaithBuilding(int faithBonus) {
        this.prayBonus = faithBonus;
    }

    public Integer getPrayBonus() {
        return prayBonus;
    }
}
