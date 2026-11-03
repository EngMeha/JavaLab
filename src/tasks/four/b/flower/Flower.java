package tasks.four.b.flower;

/** Цветок. Абстрактный класс: общие поля всех цветов, а название задаёт подкласс */
public abstract class Flower {
    private int price;
    private int freshness;
    private int stemLength;

    /**
     * @param price цена в рублях
     * @param freshness уровень свежести от 1 до 10
     * @param stemLength длина стебля в сантиметрах
     */
    public Flower(int price, int freshness, int stemLength) {
        this.price = price;
        this.freshness = freshness;
        this.stemLength = stemLength;
    }

    /** У каждого цветка своё название */
    public abstract String getName();

    public int getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return getName() + ": цена " + price + " руб., свежесть " + freshness
                + ", стебель " + stemLength + " см";
    }
}
