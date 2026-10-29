package tasks.one.a;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class A {
    private static final String PASSWORD = "qwerty";
    private static final String DEVELOPER = "Игнац";
    private static final LocalDateTime RECEIVED = LocalDateTime.of(2026, 10, 29, 17, 0);

    public static void main(String[] args){
        System.out.println("Это вариант А");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Выберите задание от 1 до 6 или введите exit для выхода:");
            String n = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            switch (n){
                case "1":
                    System.out.println("Введите ваше имя");
                    String name = scanner.nextLine().trim();
                    System.out.println("Здравствуйте, " + name);
                    break;
                case "2":
                    System.out.println("Введите аргументы через пробел");
                    String[] words = scanner.nextLine().split(" ");
                    for (int i = words.length - 1; i >= 0; i--) {
                        System.out.print(words[i] + " ");
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Введите количество случайных чисел");
                    int count;
                    try {
                        count = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Нужно ввести целое число");
                        break;
                    }
                    Random random = new Random();
                    System.out.println("С переходом на новую строку:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(random.nextInt(100));
                    }
                    System.out.println("Без перехода на новую строку:");
                    for (int i = 0; i < count; i++) {
                        System.out.print(random.nextInt(100) + " ");
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Введите пароль");
                    String password = scanner.nextLine();
                    if (password.equals(PASSWORD)) {
                        System.out.println("Пароль верный");
                    } else {
                        System.out.println("Пароль неверный");
                    }
                    break;
                case "5":
                    System.out.println("Введите целые числа через пробел");
                    String[] numbers = scanner.nextLine().split(" ");
                    int sum = 0;
                    int product = 1;
                    try {
                        for (int i = 0; i < numbers.length; i++) {
                            int value = Integer.parseInt(numbers[i]);
                            sum += value;
                            product *= value;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Нужно вводить только целые числа");
                        break;
                    }
                    System.out.println("Сумма: " + sum);
                    System.out.println("Произведение: " + product);
                    break;
                case "6":
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                    System.out.println("Разработчик: " + DEVELOPER);
                    System.out.println("Задание получено: " + RECEIVED.format(formatter));
                    System.out.println("Задание сдано: " + LocalDateTime.now().format(formatter));
                    break;
                case "exit":
                    System.out.println("Выходим из варианта А");
                    return;
                default:
                    System.out.println("Выберите вариант из доступных");
            }
        }
    }
}
