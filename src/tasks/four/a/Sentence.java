package tasks.four.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {
    private List<Word> words = new ArrayList<>();

    public Sentence(String line) {
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            words.add(new Word(parts[i]));
        }
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                result += " ";
            }
            result += words.get(i);
        }
        return result;
    }
}
