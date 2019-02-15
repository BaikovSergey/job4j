package ru.job4j.singleton;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public class TrackerInnerClass {

    /**
     * Закрытый конструктор.
     */
    private TrackerInnerClass() {
    }

    /**
     * Метод внутреннего класса. Зосдает новый экземпляр класса TrackerInnerClass.
     * @return экземпляр класса
     */
    public static TrackerInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Внутренний класс.
     */
    public static class Holder {

        /**
         * Создание статической неизменяемой переменной.
         */
        public static final TrackerInnerClass INSTANCE = new TrackerInnerClass();
    }
}
