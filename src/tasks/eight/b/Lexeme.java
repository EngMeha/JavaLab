package tasks.eight.b;

/** Лексема: часть предложения. Это либо слово, либо знак препинания */
public abstract class Lexeme {
    private boolean spaceBefore;

    public Lexeme(boolean spaceBefore) {
        this.spaceBefore = spaceBefore;
    }

    /** Нужен, чтобы собрать предложение обратно с пробелами на тех же местах */
    public boolean hasSpaceBefore() {
        return spaceBefore;
    }

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }
}
