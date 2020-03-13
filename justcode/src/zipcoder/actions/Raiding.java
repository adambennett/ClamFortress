package zipcoder.actions;

import zipcoder.models.beings.*;

public class Raiding extends AbstractGameAction {

    public Raiding(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.RAIDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
