package ru.job4j.streamapi;


import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 09.03.19
 */
public class StreamAPI {

    /**
     * Method filters even numbers of array, when takes square of this numbers and when takes sum of all.
     * @param array array of even numbers
     * @return sum
     */
    public OptionalInt evenSquareSum(int[] array) {
        IntStream test = Arrays.stream(array);
        return test
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer = (int) Math.pow(integer, 2))
                .reduce((integer, integer2) -> integer + integer2);
    }
}
