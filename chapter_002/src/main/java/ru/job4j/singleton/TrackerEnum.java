package ru.job4j.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public enum TrackerEnum {
   ITEMS;

    /**
         * Список для хранение заявок.
         */
        private final List<ItemSingleton> items = new ArrayList<>();

        /**
         * Метод реализаущий добавление заявки в хранилище
         * @param item новая заявка
         */
        public ItemSingleton add(ItemSingleton item) {
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
        public boolean replace(String id, ItemSingleton item) {
            boolean result = false;
            ItemSingleton find = items
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.getId().equals(id))
                    .findAny()
                    .orElse(null);
            if (find != null) {
                String itemId = find.getId();
                item.setId(itemId);
                this.items.set(this.items.indexOf(find), item);
                result = true;
            }
            return result;
        }

        /**
         * Метод удаляет ячейку в списке this.items.
         * @param id id.
         */
        public boolean delete(String id) {
            boolean result = false;
            ItemSingleton find = items
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.getId().equals(id))
                    .findAny()
                    .orElse(null);
            if (find != null) {
                this.items.remove(find);
                result = true;
            }
            return result;
        }

        /**
         * Метод возвращает копию списка в виде массива this.items без null элементов.
         * @return массив.
         */
        public List<ItemSingleton> findAll() {
            return this.items;
        }

        /**
         * Метод проверяет в цикле все элементы списка this.items,
         * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
         * Элементы, у которых совпадает name, копирует в результирующий список и возвращает его.
         * @return список элементов.
         */
        public List<ItemSingleton> findByName(String key) {
            ArrayList<ItemSingleton> finds = new ArrayList<>();
            items
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.getName().equals(key))
                    .forEach(finds :: add);
            return finds;
        }

        /**
         * Метод проверяет в цикле все элементы списка this.items,
         * сравнивая id с аргументом String id и возвращает найденный Item.
         * Если Item не найден - возвращает null.
         * @return искомую заявку.
         */
        public ItemSingleton findById(String id) {
            return items
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.getId().equals(id))
                    .findAny()
                    .orElse(null);
        }
}
