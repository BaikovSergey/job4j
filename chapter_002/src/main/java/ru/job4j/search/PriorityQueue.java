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
        int index = (int) this.tasks.stream().filter(
                t -> task.getPriority() > t.getPriority()
        ).count();
        this.tasks.add(index, task);
    }

    /**
     * Метод для получения первого элемента в списке.
     * @return первый элемент.
     */
    public Task take() {
        return this.tasks.poll();
    }

    @Override
    public String toString() {
        return "PriorityQueue{"
                + "tasks="
                + tasks
                + '}';
    }
}