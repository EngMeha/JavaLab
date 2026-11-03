package tasks.six.a;

/** Книга. Специализированный метод: добавить главу */
public class Book extends Publication {
    private int chapters;

    public Book(String title) {
        super(title);
    }

    public void addChapter(String name) {
        if (!isOpen()) {
            return;
        }
        chapters++;
        System.out.println("В книгу \"" + getTitle() + "\" добавлена глава " + chapters + ": " + name);
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public String toString() {
        return super.toString() + ", глав: " + chapters;
    }
}
