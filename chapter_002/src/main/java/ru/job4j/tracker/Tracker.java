package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 12.11.18
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId(item));
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId(Item item) {
        return  String.valueOf(item.getCreated() + Math.random() * 1000);
    }

    /**
     * Метод заменяет ячейку в массиве this.items на новую заявку.
     * @param id id заявки, которую необходимо заменить.
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            Item itemId = this.items[i];
            if (itemId != null && itemId.getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }

    /**
     * Метод удаляет ячейку в массиве this.items.
     * @param id id.
     */
    public void delete(String id) {
        for (int i = 0; i < position; i++) {
            Item itemId = this.items[i];
            if (itemId != null && itemId.getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - (i + 1));
                this.items[this.items.length - 1] = null;
                position--;
                break;
            }
        }
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     * @return возвращает копию массива this.items без null элементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * @return возвращает массив элементов.
     */
    public Item[] findByName(String key) {
        int index = 0;
        Item[] finds = new Item[position];
        for (int i = 0; i < position; i++) {
            Item name = this.items[i];
            if (name != null && name.getName().equals(key)) {
                finds[index] = this.items[i];
                index++;
            }
        }
        return Arrays.copyOf(finds, index);
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @return искомую заявку.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
           Item itemId = this.items[i];
            if (itemId != null && itemId.getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}