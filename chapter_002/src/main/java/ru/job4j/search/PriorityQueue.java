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
        int i = tasks.size();
        Task find;
        if (i != 0) {
            find = this.tasks.stream()
                    .filter(s ->  s.getPriority() >= task.getPriority())
                    .findAny()
                    .orElse(null);
            if (find != null) {
                i = this.tasks.indexOf(find);
            } else {
                i = tasks.size();
            }
        }
        this.tasks.add(i, task);
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