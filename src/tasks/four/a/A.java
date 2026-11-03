package tasks.four.a;

import java.util.Scanner;

/** Вариант A, задание 1: текст из предложений и слов */
public class A {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите заголовок текста:");
        Text text = new Text(new Sentence(scanner.nextLine().trim()));

        while (true) {
            System.out.println("Введите предложение (пустая строка - закончить):");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            if (!line.equals(".")){
                line += ".";
            }
            text.addSentence(new Sentence(line));
        }

        System.out.println("Заголовок текста:");
        text.printTitle();

        System.out.println("Весь текст:");
        text.print();
    }
}
