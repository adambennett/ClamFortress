package zipcoder.actions;

import zipcoder.models.beings.*;

public class Woodcutting extends AbstractGameAction {

    public Woodcutting(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.WOODCUTTING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
