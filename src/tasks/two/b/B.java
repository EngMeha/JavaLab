package tasks.two.b;

/** Вариант B, задание 1: таблица умножения */
public class B {
    public static void main(String[] args){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}
