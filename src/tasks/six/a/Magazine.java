package tasks.six.a;

/** Журнал. Специализированный метод: подготовить следующий номер */
public class Magazine extends Publication {
    private int issue = 1;

    public Magazine(String title) {
        super(title);
    }

    public void nextIssue() {
        if (!isOpen()) {
            return;
        }
        issue++;
        System.out.println("Журнал \"" + getTitle() + "\": готовится номер " + issue);
    }

    @Override
    public String getType() {
        return "Журнал";
    }

    @Override
    public String toString() {
        return super.toString() + ", номер: " + issue;
    }
}
