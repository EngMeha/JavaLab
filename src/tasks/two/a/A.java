package tasks.two.a;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/** Вариант A, задание 1: самое короткое и самое длинное число */
public class A {
    /** Фамилия разработчика */
    private static final String DEVELOPER = "Игнац";
    /** Дата и время получения задания */
    private static final LocalDateTime RECEIVED = LocalDateTime.of(2026, 10, 30, 9, 0);

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /** Вводим количество чисел */
        System.out.println("Введите n:");
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

        /** Числа храним как строки, так проще посчитать их длину */
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите число " + (i + 1) + ":");
            String input = scanner.nextLine().trim();
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Это не целое число, попробуйте ещё раз");
                i--;
                continue;
            }
            numbers[i] = input;
        }

        /** Ищем самое короткое и самое длинное число */
        String shortest = numbers[0];
        String longest = numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i].length() < shortest.length()) {
                shortest = numbers[i];
            }
            if (numbers[i].length() > longest.length()) {
                longest = numbers[i];
            }
        }

        System.out.println("Самое короткое число: " + shortest + ", длина: " + shortest.length());
        System.out.println("Самое длинное число: " + longest + ", длина: " + longest.length());

        /** Выводим разработчика и даты */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Разработчик: " + DEVELOPER);
        System.out.println("Задание получено: " + RECEIVED.format(formatter));
        System.out.println("Задание сдано: " + LocalDateTime.now().format(formatter));
    }
}
