package tasks.four.b.flower;

/** Роза. Дополнительно знает, есть ли на стебле шипы */
public class Rose extends Flower {
    private boolean hasThorns;

    public Rose(int price, int freshness, int stemLength, boolean hasThorns) {
        super(price, freshness, stemLength);
        this.hasThorns = hasThorns;
    }

    public boolean hasThorns() {
        return hasThorns;
    }

    @Override
    public String getName() {
        return "Роза";
    }

    @Override
    public String toString() {
        return super.toString() + (hasThorns ? ", с шипами" : ", без шипов");
    }
}
