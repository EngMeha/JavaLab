package tasks.five.a;

import java.util.Scanner;

/** Вариант A, задание 1: блокнот с несколькими записями на одну дату */
public class A {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Notepad notepad = new Notepad();

        while (true){
            System.out.println("1 - добавить запись, 2 - записи на дату, 3 - все записи, exit - выход:");
            String command = scanner.nextLine().trim();
            switch (command){
                case "1":
                    System.out.println("Введите дату (например 03.11.2026):");
                    String date = scanner.nextLine().trim();
                    System.out.println("Введите запись:");
                    String text = scanner.nextLine().trim();
                    notepad.addEntry(date, text);
                    break;
                case "2":
                    System.out.println("Введите дату:");
                    notepad.printByDate(scanner.nextLine().trim());
                    break;
                case "3":
                    notepad.printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Выберите вариант из доступных");
            }
        }
    }
}
