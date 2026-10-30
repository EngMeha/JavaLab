package tasks.three.b;

import java.util.Scanner;

/** Вариант B, задание 1: массив дробей */
public class B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество дробей k:");
        int k;
        try {
            k = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
            return;
        }
        if (k <= 0) {
            System.out.println("k должно быть больше 0");
            return;
        }

        Fraction[] fractions = new Fraction[k];
        for (int i = 0; i < k; i++) {
            System.out.println("Дробь " + (i + 1) + ": введите числитель и знаменатель через пробел:");
            String[] parts = scanner.nextLine().trim().split(" ");
            try {
                int m = Integer.parseInt(parts[0]);
                int n = Integer.parseInt(parts[1]);
                fractions[i] = new Fraction(m, n);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Нужно ввести два целых числа, попробуйте ещё раз");
                i--;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ", попробуйте ещё раз");
                i--;
            }
        }

        System.out.println("Введенные дроби:");
        printFractions(fractions);

        /** Пример всех четырёх действий на первых двух дробях */
        if (k >= 2) {
            Fraction a = fractions[0];
            Fraction b = fractions[1];
            System.out.println(a + " + " + b + " = " + a.add(b));
            System.out.println(a + " - " + b + " = " + a.subtract(b));
            System.out.println(a + " * " + b + " = " + a.multiply(b));
            if (b.getM() != 0) {
                System.out.println(a + " / " + b + " = " + a.divide(b));
            }
        }

        changeEven(fractions);
        System.out.println("После изменения элементов с четным индексом:");
        printFractions(fractions);
    }

    /** К каждому элементу с четным индексом прибавляем следующий за ним */
    public static void changeEven(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i] = fractions[i].add(fractions[i + 1]);
        }
    }

    public static void printFractions(Fraction[] fractions) {
        for (int i = 0; i < fractions.length; i++) {
            System.out.print(fractions[i] + "  ");
        }
        System.out.println();
    }
}
