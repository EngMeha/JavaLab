package tasks.one.b;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        System.out.println("Это вариант B");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите n:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine();

        while (true){
            System.out.println("Выберите задание (1, 2, 7) или exit для выхода:");
            String task = scanner.nextLine().trim();
            switch (task){
                case "1":
                    System.out.print("Четные: ");
                    for (int number : numbers) {
                        if (number % 2 == 0) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                    System.out.print("Нечетные: ");
                    for (int number : numbers) {
                        if (number % 2 != 0) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                    break;
                case "2":
                    int min = numbers[0];
                    int max = numbers[0];
                    for (int number : numbers) {
                        min = Math.min(min, number);
                        max = Math.max(max, number);
                    }
                    System.out.println("Наибольшее: " + max);
                    System.out.println("Наименьшее: " + min);
                    break;
                case "7":
                    int[] sorted = numbers.clone();
                    Arrays.sort(sorted);
                    System.out.print("По возрастанию: ");
                    for (int j : sorted) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    System.out.print("По убыванию: ");
                    for (int i = sorted.length - 1; i >= 0; i--) {
                        System.out.print(sorted[i] + " ");
                    }
                    System.out.println();
                    break;
                case "exit":
                    System.out.println("Выходим из варианта B");
                    return;
                default:
                    System.out.println("Выберите вариант из доступных");
            }
        }
    }
}
