package ru.job4j.converter;
/**
 * Корвертор валюты.
 * @author Sergey Baikov
 * @since 22.10.18
 */

public class Converter {
    /**
     * Курс доллара
     */
    private static final short KURSDOLLAR = 60;
    /**
     * Курс евро
     */
    private static final short KURSEUVRO = 70;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / KURSEUVRO;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / KURSDOLLAR;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * KURSEUVRO;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return value * KURSDOLLAR;
    }
}
