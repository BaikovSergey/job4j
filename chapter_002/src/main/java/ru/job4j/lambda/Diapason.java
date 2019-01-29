package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 24.01.19
 */
public class Diapason {

    /**
     * Метод расчитыает значение заданной функции в диапазоне.
     * @param start начальное значение.
     * @param end конечное значение.
     * @param func функция.
     * @return результат в виде списка.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
