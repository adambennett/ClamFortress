package zipcoder.actions;

import zipcoder.models.beings.*;

public class Building extends AbstractGameAction {

    public Building(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.BUILDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
