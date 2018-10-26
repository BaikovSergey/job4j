package ru.job4j.max;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Нахождение максимального числа из двух данных.
     * @param first первое число.
     * @param second второе число.
     * @return максимальное число.
     */
    public int max(int first, int second) {
       return  (first > second) ? first : second;
    }
    /**
     * Нахождение максимального числа из двух данных.
     * @param first первое число.
     * @param second второе число.
     * @param third второе число.
     * @return максимальное число.
     */
    public int max(int first, int second, int third) {
        int temp1 = this.max(first, second);
        return this.max(temp1, third);
    }
}
