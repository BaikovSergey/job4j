package ru.job4j.streamapi;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 09.03.19
 */
public class StreamAPI {

    /**
     * Returns list of even elements.
     * @param list list of even elements
     * @return list of even elements
     */
    public List<Integer> evenFilter(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     * Squaring all elements of list.
     * @param list list of even elements
     * @return list of squared elements
     */
    public List<Integer> toSquare(List<Integer> list) {
        return list.stream()
                .map(integer -> integer = (int) Math.pow(integer, 2))
                .collect(Collectors.toList());
    }

    /**
     * Return sum of all elements in the list.
     * @param list list of even elements
     * @return sum of elements
     */
    public Optional<Integer> sumOfElements(List<Integer> list) {
        return list.stream()
                .reduce((integer, integer2) -> integer + integer2);

    }
}
