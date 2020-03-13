package zipcoder.actions;

import zipcoder.models.beings.*;

public class Fishing extends AbstractGameAction {

    public Fishing(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.FISHING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
