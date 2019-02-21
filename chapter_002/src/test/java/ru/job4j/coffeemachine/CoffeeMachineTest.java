package ru.job4j.coffeemachine;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 20.02.19
 */
public class CoffeeMachineTest {

    /**
     * Test changes.
     */
    @Test
    public void whenValueIs100AndPrice65Then1010105() {
        CoffeeMachine test = new CoffeeMachine();
        int[] result = test.changes(100, 65);
        int[] expect = {10, 10, 10, 5};
        assertThat(result, is(expect));
    }

    /**
     * Test changes.
     */
    @Test
    public void whenValueIs100AndPrice82Then10521() {
        CoffeeMachine test = new CoffeeMachine();
        int[] result = test.changes(100, 82);
        int[] expect = {10, 5, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Test changes.
     */
    @Test
    public void whenValueIs100AndPrice35AndOnlyOnesThen35Ones() {
        CoffeeMachine test = new CoffeeMachine();
        int[] denominations = new int[100 - 35];
        Arrays.fill(denominations, 1);
        test.setDenominations(denominations);
        int[] result = test.changes(100, 35);
        int[] expect = new int[100 - 35];
        Arrays.fill(expect, 1);
        assertThat(result, is(expect));
    }
}