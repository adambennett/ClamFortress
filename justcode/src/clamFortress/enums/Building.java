package clamFortress.enums;

/*

Actually, in retrospect this seems like a poor design pattern for Buildings.
This means every building must have the same type of fields, the constructors must be filled with
static numbers at runtime (no using population in cost), and the only advantage we are getting instead
of just using a regular object for each building is that we can refer to them by i.e. Building.DITCH

Let's use a regular class for each individual building, with some abstract classes dividing them up
a bit, similar to how we have the other objects setup

ie

AbstractBuilding
AbstractDefenses
AbstractStorehouse
AbstractRefining
AbstractHouse
etc.
(there should be several more I am sure, I only looked at the first part of the list to make this comment)

and then from there...

AbstractDefenses extends AbstractBuilding
Ditch extends AbstractDefenses

AbstractHouse extends AbstractBuilding
LeanTo extends AbstractHouse

etc.

I have already made the stubs for some of this in the models package
If you make new abstracts, make new sub-packages in the models->buildings->concrete package for each one

*/
public enum Building {
    DITCH(1, 0), WOOD_SPIKE_WALL(1, 75);

    private Integer defenseBoost;
    private Integer cost;

    Building(int defenseBoost, int cost) {
        this.defenseBoost = defenseBoost;
        this.cost = cost;
    }

    public Integer getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(Integer defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
