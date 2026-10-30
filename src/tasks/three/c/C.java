package tasks.three.c;

import tasks.three.b.Fraction;

import java.util.Random;
import java.util.Scanner;

/** Вариант C, задание 1: сумма массива полиномов */
public class C {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество полиномов n:");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
            return;
        }
        if (n <= 0) {
            System.out.println("n должно быть больше 0");
            return;
        }

        /** Заполняем полиномы случайными дробями: степень от 0 до 3 */
        Random random = new Random();
        Polynomial[] polynomials = new Polynomial[n];
        for (int i = 0; i < n; i++) {
            int degree = random.nextInt(4);
            Fraction[] coefficients = new Fraction[degree + 1];
            for (int j = 0; j <= degree; j++) {
                coefficients[j] = new Fraction(random.nextInt(11) - 5, random.nextInt(5) + 1);
            }
            polynomials[i] = new Polynomial(coefficients);
            System.out.println("P" + (i + 1) + " = " + polynomials[i]);
        }

        Polynomial sum = new Polynomial(0);
        for (int i = 0; i < n; i++) {
            sum = sum.add(polynomials[i]);
        }
        System.out.println("Сумма = " + sum);
    }
}
