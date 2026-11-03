package tasks.four.b.flower;

/** Тюльпан. Дополнительно хранит цвет */
public class Tulip extends Flower {
    private String color;

    public Tulip(int price, int freshness, int stemLength, String color) {
        super(price, freshness, stemLength);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return "Тюльпан";
    }

    @Override
    public String toString() {
        return super.toString() + ", цвет " + color;
    }
}
