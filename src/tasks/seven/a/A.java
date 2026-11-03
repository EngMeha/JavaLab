package tasks.seven.a;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.PatternSyntaxException;

/** Вариант A, задание 1: каррирование. Функция берёт один аргумент и возвращает функцию для следующего */
public class A {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;
        Function<String, Function<String, Boolean>> matches = regex -> line -> line.matches(regex);
        Function<String, Function<String, String[]>> split = regex -> line -> line.split(regex);

        try {
            System.out.println("Введите первое число:");
            int a = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Введите второе число:");
            int b = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Сумма: " + add.apply(a).apply(b));
        } catch (NumberFormatException e) {
            System.out.println("Нужно ввести целое число");
        }

        System.out.println("Введите регулярное выражение (например \\d+ или ,\\s*):");
        String regex = scanner.nextLine();
        System.out.println("Введите строку:");
        String line = scanner.nextLine();
        try {
            System.out.println("Подходит под выражение: " + matches.apply(regex).apply(line));
            System.out.println("Разбиение: " + Arrays.toString(split.apply(regex).apply(line)));
        } catch (PatternSyntaxException e) {
            System.out.println("Неверное регулярное выражение");
        }

        /** Смысл каррирования: первый аргумент можно зафиксировать и получить новую функцию */
        Function<Integer, Integer> addFive = add.apply(5);
        Function<String, Boolean> isNumber = matches.apply("\\d+");
        Function<String, String[]> splitByComma = split.apply(",");
        System.out.println("Примеры с зафиксированным первым аргументом:");
        System.out.println("addFive(3) = " + addFive.apply(3));
        System.out.println("isNumber(\"123\") = " + isNumber.apply("123"));
        System.out.println("isNumber(\"12a\") = " + isNumber.apply("12a"));
        System.out.println("splitByComma(\"a,b,c\") = " + Arrays.toString(splitByComma.apply("a,b,c")));
    }
}
