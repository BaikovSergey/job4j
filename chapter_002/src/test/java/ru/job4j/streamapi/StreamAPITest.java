package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class StreamAPITest {

    @Test
    public void whenFilterEvenNumbersThenOnlyEvenNumbersLeft() {
        StreamAPI test = new StreamAPI();
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> result = test.evenFilter(list);
        List<Integer> expect = Arrays.asList(2);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAllElementsToSquareThenAllElementsToSquare() {
        StreamAPI test = new StreamAPI();
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> result = test.toSquare(list);
        List<Integer> expect = Arrays.asList(1, 4, 9);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSumOfElementsThenSix() {
        StreamAPI test = new StreamAPI();
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> result = test.sumOfElements(list);
        Optional<Integer> expect = Optional.of(6);
        assertThat(result, is(expect));
    }
}