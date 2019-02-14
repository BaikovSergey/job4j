package ru.job4j.singleton;

public class TrackerInnerClass {

    public TrackerInnerClass() {
    }

    public static TrackerInnerClass getInstance() {
        return Holder.instance;
    }

    public static class Holder {
        public static final TrackerInnerClass instance = new TrackerInnerClass();
    }
}
