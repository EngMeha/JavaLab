package tasks.six.a;

/** Учебное пособие. Специализированный метод: добавить упражнения */
public class Textbook extends Publication {
    private int exercises;

    public Textbook(String title) {
        super(title);
    }

    public void addExercises(int count) {
        if (!isOpen()) {
            return;
        }
        exercises += count;
        System.out.println("В пособие \"" + getTitle() + "\" добавлено упражнений: " + count);
    }

    @Override
    public String getType() {
        return "Учебное пособие";
    }

    @Override
    public String toString() {
        return super.toString() + ", упражнений: " + exercises;
    }
}
