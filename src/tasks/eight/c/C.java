package tasks.eight.c;

import java.util.Scanner;

/** Вариант C, задание 1: проверка сильного пароля */
public class C {
    /**
     * (?=.*[0-9]) - где-то есть цифра
     * (?=.*[a-z]) - где-то есть маленькая буква
     * (?=.*[A-Z]) - где-то есть большая буква
     * [A-Za-z0-9_]{10,} - только разрешенные символы, не меньше 10 штук
     */
    private static final String STRONG_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[A-Za-z0-9_]{10,}";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        if (password.matches(STRONG_PASSWORD)) {
            System.out.println("Пароль сильный");
            return;
        }

        /** Пароль слабый: проверяем условия по отдельности, чтобы сказать, что не так */
        System.out.println("Пароль слабый:");
        if (password.length() < 10) {
            System.out.println("- длина меньше 10 символов");
        }
        if (!password.matches(".*[0-9].*")) {
            System.out.println("- нет цифры");
        }
        if (!password.matches(".*[a-z].*")) {
            System.out.println("- нет маленькой латинской буквы");
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("- нет большой латинской буквы");
        }
        String forbidden = password.replaceAll("[A-Za-z0-9_]", "");
        if (!forbidden.isEmpty()) {
            System.out.println("- есть запрещенные символы: \"" + forbidden + "\"");
        }
    }
}
