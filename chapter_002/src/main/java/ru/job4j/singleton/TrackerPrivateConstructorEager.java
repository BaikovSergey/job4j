package ru.job4j.singleton;

public class TrackerPrivateConstructorEager {

    private static final TrackerPrivateConstructorEager INSTANCE = new TrackerPrivateConstructorEager();

    public TrackerPrivateConstructorEager() {
    }

    public static TrackerPrivateConstructorEager getInstance() {
        return INSTANCE;
    }
}
