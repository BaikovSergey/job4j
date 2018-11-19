package ru.job4j.array;


/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 07.11.18
 */
public class ArrayAdd {

    /**
     * Формирует новый сортированный массив из двух данных.
     *
     * @param first  первый массив.
     * @param second второй массив.
     * @return массив.
     */
    public int[] add(int[] first, int[] second) {
            int indArray1;
            int indArray2;
            int indArrayRes;
            int[] array = new int[first.length + second.length];
            for (indArray1 = 0, indArray2 = 0, indArrayRes = 0; indArray1 < first.length & indArray2 < second.length & indArrayRes <= array.length;) {
                if (first[indArray1] < second[indArray2]) {
                    array[indArrayRes] = first[indArray1];
                    indArray1++;
                } else {
                    array[indArrayRes] = second[indArray2];
                    indArray2++;
                }
                indArrayRes++;
            }
            if (indArray1 != first.length) {
                for (int i = indArray1; i < first.length; i++) {
                    array[indArrayRes] = first[i];
                    indArrayRes++;
                }
            } else {
                for (int j = indArray2; j < second.length; j++) {
                    array[indArrayRes] = second[j];
                    indArrayRes++;
                }
            }
        return array;
    }
}
