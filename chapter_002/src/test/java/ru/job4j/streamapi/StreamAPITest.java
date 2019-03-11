package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class StreamAPITest {

    @Test
    public void whenFilterEvenNumbersThenOnlyEvenNumbersLeft() {
        StreamAPI test = new StreamAPI();
        int[] array = {1, 2, 3, 4, 5};
        OptionalInt result = test.evenSquareSum(array);
        OptionalInt expect = OptionalInt.of(20);
        assertThat(result, is(expect));
    }
}