package zipcoder.actions;

import zipcoder.models.beings.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.HARVESTING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
