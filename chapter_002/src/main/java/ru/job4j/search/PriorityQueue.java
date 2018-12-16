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
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
        }
    }

    /**
     * Метод для получения первого элемента в списке.
     * @return первый элемент.
     */
    public Task takeFirst() {
        return this.tasks.get(0);
    }

    /**
     * Метод для получения второго элемента в списке.
     * @return второй элемент.
     */
    public Task takeMid() {
        return this.tasks.get(1);
    }

    /**
     * Метод для получения третьего элемента в списке.
     * @return третий элемент.
     */
    public Task takeLast() {
        return this.tasks.get(2);
    }
}