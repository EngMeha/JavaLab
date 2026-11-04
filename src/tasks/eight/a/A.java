package tasks.eight.a;

import java.util.Scanner;

/** Вариант A, задание 1: заменить k-ю букву в каждом слове */
public class A {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите k:");
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

        System.out.println("Введите символ:");
        String symbol = scanner.nextLine();
        if (symbol.length() != 1) {
            System.out.println("Нужно ввести ровно один символ");
            return;
        }

        /** position - номер буквы в текущем слове. Не буква значит, что слово закончилось */
        String result = "";
        int position = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                position++;
                if (position == k) {
                    c = symbol.charAt(0);
                }
            } else {
                position = 0;
            }
            result += c;
        }
        System.out.println("Результат: " + result);
    }
}
