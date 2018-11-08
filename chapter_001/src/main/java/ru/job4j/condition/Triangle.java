package ru.job4j.condition;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 0.1
 */
public class Triangle {

    /**
     * Содержит значение точки a.
     */
    private Point a;

    /**
     * Содержит значение точки b.
     */
    private Point b;

    /**
     * Содержит значение точки c.
     */
    private Point c;

    /**
     * Содержит значение 0.5 для расчета полупериметра.
     */
    private static final double HALFPERIMETR = 0.5D;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) * HALFPERIMETR;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(
                 p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return result;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return Да или Нет.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && ac + bc > ab && ab > 0 && ac > 0 && bc > 0;
    }
}
