package tasks.eight.b;

import java.util.ArrayList;
import java.util.List;

/** Текст учебника: состоит из абзацев и листингов */
public class Text {
    private List<TextBlock> blocks = new ArrayList<>();

    public void addBlock(TextBlock block) {
        blocks.add(block);
    }

    public List<Sentence> getSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (TextBlock block : blocks) {
            sentences.addAll(block.getSentences());
        }
        return sentences;
    }

    public List<Sentence> findSentencesWith(String word) {
        List<Sentence> result = new ArrayList<>();
        for (Sentence sentence : getSentences()) {
            if (sentence.containsWord(word)) {
                result.add(sentence);
            }
        }
        return result;
    }

    /** Слово, которое встречается в наибольшем количестве предложений */
    public String findMostCommonWord() {
        String best = null;
        int bestCount = 0;
        for (Sentence sentence : getSentences()) {
            for (Word word : sentence.getWords()) {
                int count = findSentencesWith(word.getValue()).size();
                if (count > bestCount) {
                    bestCount = count;
                    best = word.getValue();
                }
            }
        }
        return best;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < blocks.size(); i++) {
            if (i > 0) {
                result += "\n\n";
            }
            result += blocks.get(i);
        }
        return result;
    }
}
