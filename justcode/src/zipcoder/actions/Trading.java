package zipcoder.actions;

import zipcoder.models.beings.*;

public class Trading extends AbstractGameAction {

    public Trading(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.TRADING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
