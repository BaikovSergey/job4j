package ru.job4j.singleton;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public class TrackerPrivateConstructorEager {

    /**
     * Создание статической переменной.
     */
    private static final TrackerPrivateConstructorEager INSTANCE = new TrackerPrivateConstructorEager();

    /**
     * Закрытый конструктор.
     */
    private TrackerPrivateConstructorEager() {
    }

    /**
     * Метод для ссылки на объект класса.
     * @return ссылка
     */
    public static TrackerPrivateConstructorEager getInstance() {
        return INSTANCE;
    }
}
