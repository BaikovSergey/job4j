package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version $Id$
 * @since 19.11.18
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для вывода всех заявок.
     */
    private static final String FINDALL = "1";

    /**
     * Константа меню для замены заявки.
     */
    private static final String REPLACE = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по Id.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для поиска заявки по Id.
     */
    private static final String FINDBYNAME = "5";


    /**
     * Константа для выхода из цикла.
     */
    private boolean exit = false;

    public void exit() {
        this.exit = true;
    }

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] range = new int[]{0, 1, 2, 3, 4, 5, 6};
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню: ", range));
        } while (!this.exit);
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок.
     */
    private void findAllItems() {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] founds = tracker.findAll();
        for (int i = 0; i < founds.length; i++) {
            System.out.println(founds[i].toString());
            System.out.println(System.lineSeparator());
        }
    }

    /**
     * Метод реализует замену заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Замена заявки --------------");
        String id = this.input.ask("Введите Id заявки, котрую хотите заменить: ");
        String name = this.input.ask("Введите имя новой заявки: ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------ Заявка успешно заменена -----------");
            System.out.println("Имя заявки: " + name);
            System.out.println("Id заявки: " + id);
        } else {
            System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
        }

    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки :");
        if (tracker.delete(id)) {
            System.out.println("------------ Заявка с Id: " + id + " удалена -----------");
        } else {
            System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
        }

    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id заявки :");
        Item founds = tracker.findById(id);
        if (founds != null && founds.getId().equals(id)) {
            System.out.println("------------ Заявка с Id: " + id + " -----------");
            System.out.println(founds.toString());
        } else {
            System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
        }
    }

    /**
     * Метод реализует поиск заявки по Name.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        System.out.println("------------ Заявки с именем: " + name + " -----------");
        for (int i = 0; i < tracker.findByName(name).length; i++) {
            System.out.println("Id заявки: " + tracker.findByName(name)[i].getId());
            System.out.println("Описание заявки: " + tracker.findByName(name)[i].getDesc());
        }
    }

    /**
     * Метод выводит на консоль пункты меню.
     */
    private void showMenu() {
        System.out.println(new StringBuilder()
                .append("Меню.")
                .append(System.lineSeparator())
                .append("0. Добавление новой заявки.")
                .append(System.lineSeparator())
                .append("1. Показать все заявки.")
                .append(System.lineSeparator())
                .append("2. Замена заявки.")
                .append(System.lineSeparator())
                .append("3. Удаление заявки.")
                .append(System.lineSeparator())
                .append("4. Поиск заявки по Id.")
                .append(System.lineSeparator())
                .append("5. Поиск заявки по имени.")
                .append(System.lineSeparator())
                .append("6. Завершение работы программы.")
                .append(System.lineSeparator()));

    }

    /**
     * Запускт программы.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}