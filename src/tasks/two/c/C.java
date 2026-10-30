package tasks.two.c;

import java.util.Random;
import java.util.Scanner;

/** Вариант C, задание 1: упорядочить строки матрицы по k-му столбцу */
public class C {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n;
        int k;
        try {
            System.out.println("Введите размерность матрицы n:");
            n = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Введите номер столбца k (от 1 до " + n + "):");
            k = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
            return;
        }
        if (n <= 0 || k < 0 || k >= n) {
            System.out.println("Неверные n или k");
            return;
        }

        /** Заполняем матрицу случайными числами от -n до n */
        Random random = new Random();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }
        System.out.println("Исходная матрица:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        /** Сортировка пузырьком: меняем строки местами целиком */
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j][k] > a[j + 1][k]) {
                    int[] temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("Строки упорядочены по " + (k + 1) + "-му столбцу:");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
