package ru.job4j.search;

import java.util.LinkedList;
import java.util.Objects;

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
                    .filter(s -> task.getPriority() <= s.getPriority())
                    .findAny()
                    .orElse(task);
            i = this.tasks.indexOf(find);
        }

        this.tasks.add(i, task);
    }
//    public void put(Task task) {
//        int i = tasks.size();
//        for (int index = 0; index < tasks.size(); index++) {
//            if (task.getPriority() <= tasks.get(index).getPriority()) {
//                i = index;
//                break;
//            }
//        }
//        tasks.add(i, task);
//    }

    /**
     * Метод для получения первого элемента в списке.
     * @return первый элемент.
     */
    public Task take() {
        return this.tasks.poll();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "tasks=" + tasks +
                '}';
    }
}