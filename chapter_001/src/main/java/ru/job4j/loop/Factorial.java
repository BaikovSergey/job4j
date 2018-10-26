package ru.job4j.loop;
/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 26.10.18
 */

public class Factorial {

    /**
     * Нахождение факториала заданного числа.
     * @param n число, факториал которого нужно определить.
     * @return произведение.
     */
    public int calc(int n) {
        int fac = 1;
        if (n > 0) {
            for (int i = 1; i < n + 1; i++) {
                fac *= i;
        }
                }
        return fac;
    }
}
