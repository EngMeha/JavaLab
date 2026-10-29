package tasks.one;

import tasks.one.a.A;
import tasks.one.b.B;

import java.util.Locale;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args)
    {
        System.out.println("Это задание 1");
        Scanner scanner = new Scanner(System.in);
        while (true){

            System.out.println("Выберите вариант A или B или введите exit для выхода:");
            String var = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            switch (var){
                case "a":
                    A.main(args);
                    break;
                case "b":
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
