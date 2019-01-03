package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $2$
 * @since 12.11.18
 */
public class Tracker {

    /**
     * Список для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int  position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return  String.valueOf((Math.random() * 1000));
    }

    /**
     * Метод заменяет ячейку в списке this.items на новую заявку.
     * @param id id заявки, которую необходимо заменить.
     * @param item новая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            Item itemId = this.items.get(i);
            if (itemId != null && itemId.getId().equals(id)) {
                this.items.add(i, item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет ячейку в списке this.items.
     * @param id id.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            Item itemId = this.items.get(i);
            if (itemId != null && itemId.getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию списка в виде массива this.items без null элементов.
     * @return массив.
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Метод проверяет в цикле все элементы списка this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий список и возвращает его.
     * @return список элементов.
     */
    public ArrayList findByName(String key) {
        ArrayList<Item> finds = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            Item name = this.items.get(i);
            if (name != null && name.getName().equals(key)) {
                finds.add(name);
            }
        }
        return finds;
    }

    /**
     * Метод проверяет в цикле все элементы списка this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @return искомую заявку.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
           Item itemId = this.items.get(i);
            if (itemId != null && itemId.getId().equals(id)) {
                result = this.items.get(i);
                break;
            }
        }
        return result;
    }
}