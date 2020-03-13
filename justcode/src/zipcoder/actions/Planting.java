package zipcoder.actions;

import zipcoder.models.beings.*;

public class Planting extends AbstractGameAction {

    public Planting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.PLANTING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
