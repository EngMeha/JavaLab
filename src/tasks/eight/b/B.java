package tasks.eight.b;

import java.util.List;

/** Вариант B, задание 1: наибольшее количество предложений с одинаковым словом */
public class B {
    private static final String SOURCE =
            "Класс   описывает свойства объекта.\tОбъект создается оператором new. "
            + "Каждый класс может иметь конструкторы!\n"
            + "\n"
            + "Листинг 1. Пример:\n"
            + "class Student {\n"
            + "    int id;\n"
            + "}\n"
            + "\n"
            + "Что наследует подкласс? Он получает методы родителя, "
            + "а его родительский класс остается прежним.\n"
            + "\n"
            + "Интерфейс задает только контракт.";

    public static void main(String[] args){
        Text text = new TextParser().parse(SOURCE);

        System.out.println("Текст после разбора:");
        System.out.println(text);
        System.out.println();

        String word = text.findMostCommonWord();
        if (word == null) {
            System.out.println("В тексте нет слов");
            return;
        }

        List<Sentence> sentences = text.findSentencesWith(word);
        if (sentences.size() < 2) {
            System.out.println("Одинаковых слов в разных предложениях нет");
            return;
        }

        System.out.println("Наибольшее количество предложений с одинаковым словом: " + sentences.size());
        System.out.println("Слово: " + word);
        for (Sentence sentence : sentences) {
            System.out.println("  " + sentence);
        }
    }
}
