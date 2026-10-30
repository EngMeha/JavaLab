package tasks.three.c;

import tasks.three.b.Fraction;

/** Полином с коэффициентами-дробями. coefficients[i] — коэффициент при x^i */
public class Polynomial {
    private Fraction[] coefficients;

    /** Нулевой полином заданной степени */
    public Polynomial(int degree) {
        coefficients = new Fraction[degree + 1];
        for (int i = 0; i <= degree; i++) {
            coefficients[i] = new Fraction();
        }
    }

    public Polynomial(Fraction[] coefficients) {
        this.coefficients = coefficients;
    }

    public Fraction[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Fraction[] coefficients) {
        this.coefficients = coefficients;
    }

    public int getDegree() {
        return coefficients.length - 1;
    }

    /** Сумма полиномов: складываем коэффициенты при одинаковых степенях */
    public Polynomial add(Polynomial other) {
        int degree = Math.max(getDegree(), other.getDegree());
        Polynomial result = new Polynomial(degree);
        for (int i = 0; i <= degree; i++) {
            Fraction sum = new Fraction();
            if (i <= getDegree()) {
                sum = sum.add(coefficients[i]);
            }
            if (i <= other.getDegree()) {
                sum = sum.add(other.coefficients[i]);
            }
            result.coefficients[i] = sum;
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        /** Выводим со старшей степени */
        for (int i = getDegree(); i >= 0; i--) {
            if (coefficients[i].getM() == 0) {
                continue;
            }
            if (!result.isEmpty()) {
                result += " + ";
            }
            result += "(" + coefficients[i] + ")";
            if (i == 1) {
                result += "x";
            } else if (i > 1) {
                result += "x^" + i;
            }
        }
        if (result.isEmpty()) {
            return "0";
        }
        return result;
    }
}
