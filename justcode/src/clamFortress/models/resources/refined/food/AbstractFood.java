package clamFortress.models.resources.refined.food;

public abstract class AbstractFood {

    private Integer healing;

    public AbstractFood(Integer healing) {
        this.healing = healing;
    }

    public Integer getHealing() {
        return healing;
    }

    public void setHealing(Integer healing) {
        this.healing = healing;
    }
}
