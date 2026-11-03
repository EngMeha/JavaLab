package tasks.four.b.accessory;

/** Аксессуар для букета. Наследование не нужно */
public class Accessory {
    private String name;
    private int price;

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": цена " + price + " руб.";
    }
}
