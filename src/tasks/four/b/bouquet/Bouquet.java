package tasks.four.b.bouquet;

import tasks.four.b.accessory.Accessory;
import tasks.four.b.flower.Flower;

import java.util.ArrayList;
import java.util.List;

/** Букет из цветов и аксессуаров */
public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public int getCost() {
        int cost = 0;
        for (Flower flower : flowers) {
            cost += flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            cost += accessory.getPrice();
        }
        return cost;
    }

    public void sortByFreshness() {
        flowers.sort((a, b) -> b.getFreshness() - a.getFreshness());
    }

    /** Цветы, у которых длина стебля входит в диапазон от min до max */
    public List<Flower> findByStemLength(int min, int max) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= min && flower.getStemLength() <= max) {
                result.add(flower);
            }
        }
        return result;
    }
}
