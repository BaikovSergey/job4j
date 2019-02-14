package ru.job4j.singleton;

public class TrackerPrivateConstructorLazy {

    private static TrackerPrivateConstructorLazy instance;

    private TrackerPrivateConstructorLazy() {
    }

    public static TrackerPrivateConstructorLazy getInstance() {
        if (instance == null) {
            instance = new TrackerPrivateConstructorLazy();
        }
        return instance;
    }
}
