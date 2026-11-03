package tasks.four;

import tasks.four.a.A;
import tasks.four.b.B;

import java.util.Locale;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args)
    {
        System.out.println("Это задание 4");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Выберите задание A1, B1 или введите exit для выхода:");
            String var = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            switch (var){
                case "a1":
                    A.main(args);
                    break;
                case "b1":
                    B.main(args);
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
