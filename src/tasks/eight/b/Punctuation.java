package tasks.eight.b;

/** Знак препинания: один символ */
public class Punctuation extends Lexeme {
    private Symbol symbol;

    public Punctuation(Symbol symbol, boolean spaceBefore) {
        super(spaceBefore);
        this.symbol = symbol;
    }

    @Override
    public String getValue() {
        return symbol.toString();
    }
}
