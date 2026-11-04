package tasks.eight.b;

import java.util.ArrayList;
import java.util.List;

/** Абзац: состоит из предложений */
public class Paragraph implements TextBlock {
    private List<Sentence> sentences = new ArrayList<>();

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < sentences.size(); i++) {
            if (i > 0) {
                result += " ";
            }
            result += sentences.get(i);
        }
        return result;
    }
}
