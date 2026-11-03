package tasks.four.b.flower;

/** Ромашка */
public class Chamomile extends Flower {

    public Chamomile(int price, int freshness, int stemLength) {
        super(price, freshness, stemLength);
    }

    @Override
    public String getName() {
        return "Ромашка";
    }
}
