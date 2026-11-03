package tasks.five;

import tasks.five.a.A;

import java.util.Locale;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args)
    {
        System.out.println("Это задание 5");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Выберите задание A1 или введите exit для выхода:");
            String var = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            switch (var){
                case "a1":
                    A.main(args);
                    break;
                case "exit":
                    System.out.println("Выходим");
                    return;
                default:
                    System.out.println("Выберите вариант из доступных");
            }
        }
    }
}
