import tasks.one.Task1;
import tasks.two.Task2;
import tasks.three.Task3;
import tasks.four.Task4;
import tasks.five.Task5;
import tasks.six.Task6;
import tasks.seven.Task7;
import tasks.eight.Task8;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте это программа включает в себя все задания по курсу Java-технологии");
        while (true)
        {
            System.out.println("Выберите главу от 1 до 8 или exit для выхода");
            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            switch (input) {
                case "1":
                    Task1.main(args);
                    break;
                case "2":
                    Task2.main(args);
                    break;
                case "3":
                    Task3.main(args);
                    break;
                case "4":
                    Task4.main(args);
                    break;
                case "5":
                    Task5.main(args);
                    break;
                case "6":
                    Task6.main(args);
                    break;
                case "7":
                    Task7.main(args);
                    break;
                case "8":
                    Task8.main(args);
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