package main.models.items;

import main.actions.*;
import main.encounters.*;
import main.encounters.disasters.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.models.animals.*;
import main.models.buildings.abstracts.*;
import main.models.nodes.*;
import main.models.people.*;

public abstract class AbstractItem {

    private String name;
    private String desc;

    public AbstractItem(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Integer multiplyFoodOnFishing() { return 1; }

    public Integer multiplyFoodOnHunting() { return 1; }

    public Integer modifyFaithInc() { return 0; }

    public Integer modifyAtk() { return 0; }

    public Integer modifyDef() { return 0; }

    public Integer modifyPriorityPoints() { return 0; }

    public Integer modifyDateIncrease() { return 0; }

    public Integer modifyPopCapIncreases() { return 0; }

    public String addToEndTurnReportTop() { return ""; }

    public String addToEndTurnReportBot() { return ""; }

    public void onSpendPriorityPoints(int diff) {}

    public void onDiscoverNewRegion(AbstractNode newNode) {}

    public void onAddAnimalToBoard(AbstractAnimal animal) {}

    public void onGatherFood(AbstractGameAction gatheringType) {}

    public void afterRunAction(AbstractGameAction gatheringType) {}

    public void onNewCitizen(Survivor newCitizen) {}

    public void onLoseCitizen(Survivor newCitizen) {}

    public void onNewBuilding(AbstractBuilding b) {}

    public void onNewMiracle(AbstractMiracle m) {}

    public void onNewDisaster(AbstractDisaster d) {}

    public void onNewPlague(AbstractPlague p) {}

    public void onRunSpecialEncounter(AbstractEncounter enc) {}

    public void onDateAdvance(int daysAdvanced) {}

    public String getName() {
        return name;
    }

    public String getDesc() { return desc; }

    @Override
    public boolean equals(Object item) {
        if (item instanceof AbstractItem) {
            return (this.name.equals(((AbstractItem) item).getName()));
        } else {
            return super.equals(item);
        }
    }
}
