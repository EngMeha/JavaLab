import tasks.one.Task1;
import tasks.two.Task2;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте это программа включает в себя все задания по курсу Java-технологии");
        while (true)
        {
            System.out.println("Выберите главу от 1 до 3 или exit для выхода");
            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            switch (input) {
                case "1":
                    Task1.main(args);
                    break;
                case "2":
                    Task2.main(args);
                    break;
                case "3":
                    break;
                case "exit":
                    System.out.println("Пока");
                    return;
                default:
                    System.out.println("Такой главы нет, попробуйте ещё раз");
            }
        }
    }
}