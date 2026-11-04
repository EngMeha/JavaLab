package tasks.eight.b;

import java.util.ArrayList;
import java.util.List;

/** Слово: состоит из символов */
public class Word extends Lexeme {
    private List<Symbol> symbols = new ArrayList<>();

    public Word(boolean spaceBefore) {
        super(spaceBefore);
    }

    public void addSymbol(Symbol symbol) {
        symbols.add(symbol);
    }

    @Override
    public String getValue() {
        String result = "";
        for (Symbol symbol : symbols) {
            result += symbol;
        }
        return result;
    }
}
