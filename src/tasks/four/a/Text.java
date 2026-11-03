package tasks.four.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Текст. Состоит из заголовка и предложений
 */
public class Text {
    private Sentence title;
    private List<Sentence> sentences = new ArrayList<>();

    public Text(Sentence title) {
        this.title = title;
    }

    public Sentence getTitle() {
        return title;
    }

    public void setTitle(Sentence title) {
        this.title = title;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printTitle() {
        System.out.println(title);
    }

    public void print() {
        System.out.println(this);
    }

    /** Тексты равны, если совпадают заголовок и все предложения */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        return Objects.equals(title, text.title) && Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, sentences);
    }

    /** Заголовок на первой строке, ниже предложения через пробел */
    @Override
    public String toString() {
        String result = title + "\n";
        for (int i = 0; i < sentences.size(); i++) {
            if (i > 0) {
                result += " ";
            }
            result += sentences.get(i);
        }
        return result;
    }
}
