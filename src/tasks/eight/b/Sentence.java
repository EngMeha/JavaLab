package tasks.eight.b;

import java.util.ArrayList;
import java.util.List;

/** Предложение: состоит из лексем */
public class Sentence {
    private List<Lexeme> lexemes = new ArrayList<>();

    public void addLexeme(Lexeme lexeme) {
        lexemes.add(lexeme);
    }

    /** Только слова, без знаков препинания */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Lexeme lexeme : lexemes) {
            if (lexeme instanceof Word) {
                words.add((Word) lexeme);
            }
        }
        return words;
    }

    public boolean containsWord(String value) {
        for (Word word : getWords()) {
            if (word.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        for (Lexeme lexeme : lexemes) {
            if (lexeme.hasSpaceBefore()) {
                result += " ";
            }
            result += lexeme;
        }
        return result;
    }
}
