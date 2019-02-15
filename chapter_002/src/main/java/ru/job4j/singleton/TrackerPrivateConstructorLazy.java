package ru.job4j.singleton;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public class TrackerPrivateConstructorLazy {

    /**
     * Создание статической переменной.
     */
    private static TrackerPrivateConstructorLazy instance;

    /**
     * Закрытый конструктор.
     */
    private TrackerPrivateConstructorLazy() {
    }

    /**
     * Метод проверяет instance на null. Если true то создается новый экземпляр класса.
     * @return экземпляр класса
     */
    public static TrackerPrivateConstructorLazy getInstance() {
        if (instance == null) {
            instance = new TrackerPrivateConstructorLazy();
        }
        return instance;
    }
}
