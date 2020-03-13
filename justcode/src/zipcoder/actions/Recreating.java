package zipcoder.actions;

import zipcoder.models.beings.*;

public class Recreating extends AbstractGameAction {

    public Recreating(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.RECREATING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
