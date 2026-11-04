package tasks.eight.b;

import java.util.ArrayList;
import java.util.List;

/** Листинг: код хранится целиком и на предложения не разбирается */
public class Listing implements TextBlock {
    private String code;

    public Listing(String code) {
        this.code = code;
    }

    @Override
    public List<Sentence> getSentences() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return code;
    }
}
