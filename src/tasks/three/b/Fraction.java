package tasks.three.b;

/** Рациональная дробь m/n */
public class Fraction {
    private int m;
    private int n;

    /** Дробь 0/1 */
    public Fraction() {
        this(0, 1);
    }

    /** Целое число m/1 */
    public Fraction(int m) {
        this(m, 1);
    }

    public Fraction(int m, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        /** Минус храним только в числителе */
        if (n < 0) {
            m = -m;
            n = -n;
        }
        /** Сразу сокращаем дробь */
        int g = gcd(Math.abs(m), n);
        this.m = m / g;
        this.n = n / g;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        this.n = n;
    }

    public Fraction add(Fraction other) {
        return new Fraction(m * other.n + other.m * n, n * other.n);
    }

    public Fraction subtract(Fraction other) {
        return new Fraction(m * other.n - other.m * n, n * other.n);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(m * other.m, n * other.n);
    }

    public Fraction divide(Fraction other) {
        if (other.m == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new Fraction(m * other.n, n * other.m);
    }

    /** Наибольший общий делитель (алгоритм Евклида) */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a == 0 ? 1 : a;
    }

    @Override
    public String toString() {
        if (n == 1) {
            return String.valueOf(m);
        }
        return m + "/" + n;
    }
}
