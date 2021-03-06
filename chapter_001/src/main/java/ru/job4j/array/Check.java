package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class Check {

    /**
     * Проверяет все ли элементы массива true либо false.
     * @param data Массив.
     * @return true/false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            boolean elem = data[i];
            if (elem != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}