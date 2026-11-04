package tasks.eight.b;

/** Разбирает строку на блоки, предложения и лексемы */
public class TextParser {
    public Text parse(String source) {
        /** Табуляции и несколько пробелов подряд заменяем одним пробелом */
        String cleaned = source.replaceAll("[ \t]+", " ");

        Text text = new Text();
        /** Блоки разделены пустой строкой */
        String[] blocks = cleaned.split("\n\\s*\n");
        for (int i = 0; i < blocks.length; i++) {
            String block = blocks[i].trim();
            if (block.startsWith("Листинг")) {
                text.addBlock(new Listing(block));
            } else {
                text.addBlock(parseParagraph(block));
            }
        }
        return text;
    }

    private Paragraph parseParagraph(String block) {
        Paragraph paragraph = new Paragraph();
        /** Предложение заканчивается на . ! или ? с пробелом после знака */
        String[] sentences = block.split("(?<=[.!?])\\s+");
        for (int i = 0; i < sentences.length; i++) {
            paragraph.addSentence(parseSentence(sentences[i]));
        }
        return paragraph;
    }

    private Sentence parseSentence(String line) {
        Sentence sentence = new Sentence();
        boolean spaceBefore = false;
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) {
                spaceBefore = true;
                i++;
            } else if (Character.isLetterOrDigit(c)) {
                Word word = new Word(spaceBefore);
                while (i < line.length() && Character.isLetterOrDigit(line.charAt(i))) {
                    word.addSymbol(new Symbol(line.charAt(i)));
                    i++;
                }
                sentence.addLexeme(word);
                spaceBefore = false;
            } else {
                sentence.addLexeme(new Punctuation(new Symbol(c), spaceBefore));
                spaceBefore = false;
                i++;
            }
        }
        return sentence;
    }
}
