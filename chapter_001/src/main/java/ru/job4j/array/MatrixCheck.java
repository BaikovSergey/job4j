package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 29.10.18
 */
public class MatrixCheck {

    /**
     * Проверяет моногамность диагоналей матрицы.
     *
     * @param data массив.
     * @return true/false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
