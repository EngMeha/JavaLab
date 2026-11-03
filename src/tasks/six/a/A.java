package tasks.six.a;

/** Вариант A, задание 1: управление процессом для полиграфических изданий */
public class A {
    public static void main(String[] args){
        System.out.println("--- Книга: полный путь до печати ---");
        Book book = new Book("Война и мир");
        book.signContract();
        book.open();
        book.addChapter("Начало");
        book.edit();
        book.layout();
        book.print();
        book.pay();
        book.print();
        book.close();
        System.out.println(book);

        System.out.println("--- Журнал: отказ и возобновление ---");
        Magazine magazine = new Magazine("Наука и жизнь");
        magazine.open();
        magazine.signContract();
        magazine.open();
        magazine.nextIssue();
        magazine.refuse();
        magazine.nextIssue();
        magazine.resume();
        magazine.nextIssue();
        System.out.println(magazine);

        System.out.println("--- Учебное пособие: правка после верстки ---");
        Textbook textbook = new Textbook("Основы Java");
        textbook.signContract();
        textbook.open();
        textbook.addExercises(10);
        textbook.pay();
        textbook.layout();
        textbook.edit();
        textbook.print();
        textbook.layout();
        textbook.print();
        System.out.println(textbook);

        System.out.println("--- Все издания через общий интерфейс ---");
        PublicationProcess[] publications = {book, magazine, textbook};
        for (int i = 0; i < publications.length; i++) {
            publications[i].close();
        }
    }
}
