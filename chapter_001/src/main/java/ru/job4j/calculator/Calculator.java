package ru.job4j.calculator;
/**
 * Calculator.
 *
 *@author Sergey Baikov
 * @since 22.10.18
 */

public class Calculator {
    /**
     * Contains calculations result.
     */
    private double result;

    /**
     * Method add.
     * @param first First value.
     * @param second Second value.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method subtract.
     * @param first First value.
     * @param second Second value.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div.
     * @param first First value.
     * @param second Second value.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple.
     * @param first First value.
     * @param second Second value.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
