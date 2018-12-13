package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */

    public void put(Task task) {
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else if (tasks.get(0).getPriority() > task.getPriority()) {
            tasks.add(0,task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}