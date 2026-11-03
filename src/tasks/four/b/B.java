package tasks.four.b;

import tasks.four.b.accessory.Accessory;
import tasks.four.b.bouquet.Bouquet;
import tasks.four.b.flower.Chamomile;
import tasks.four.b.flower.Flower;
import tasks.four.b.flower.Rose;
import tasks.four.b.flower.Tulip;

import java.util.List;
import java.util.Scanner;

/** Вариант B, задание 1: цветочница */
public class B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose(150, 7, 60, true));
        bouquet.addFlower(new Rose(180, 10, 70, false));
        bouquet.addFlower(new Tulip(80, 5, 35, "красный"));
        bouquet.addFlower(new Tulip(80, 9, 30, "желтый"));
        bouquet.addFlower(new Chamomile(50, 3, 25));
        bouquet.addAccessory(new Accessory("Лента", 40));
        bouquet.addAccessory(new Accessory("Упаковка", 100));

        System.out.println("Цветы в букете:");
        for (Flower flower : bouquet.getFlowers()) {
            System.out.println(flower);
        }
        System.out.println("Аксессуары:");
        for (Accessory accessory : bouquet.getAccessories()) {
            System.out.println(accessory);
        }
        System.out.println("Стоимость букета: " + bouquet.getCost() + " руб.");

        bouquet.sortByFreshness();
        System.out.println("Цветы по свежести:");
        for (Flower flower : bouquet.getFlowers()) {
            System.out.println(flower);
        }

        int min;
        int max;
        try {
            System.out.println("Введите минимальную длину стебля:");
            min = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Введите максимальную длину стебля:");
            max = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
            return;
        }

        List<Flower> found = bouquet.findByStemLength(min, max);
        if (found.isEmpty()) {
            System.out.println("Таких цветов в букете нет");
        } else {
            System.out.println("Цветы со стеблем от " + min + " до " + max + " см:");
            for (Flower flower : found) {
                System.out.println(flower);
            }
        }
    }
}
