package ru.job4j.tracker;

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
    private static final String EXIT = "6";
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
     * @param input ввод данных.
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FINDALL.equals(answer)) {
                this.findAllItems();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else  if (FINDBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
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
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок.
     */
    private void findAllItems() {
        System.out.println("------------ Вывод всех заявок --------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(i + 1 + ". " + tracker.findAll()[i].getName());
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
        this.tracker.replace(name, item);
        System.out.println("------------ Заявка успешно заменена -----------");
        System.out.println("Имя заявки: " + tracker.findById(id).getName());
        System.out.println("Id заявки: " + id);
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки :");
        tracker.delete(id);
        System.out.println("------------ Заявка с: " + id + " удалена -----------");
    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id заявки :");
        tracker.findById(id);
        System.out.println("------------ Заявка с Id: " + id + " -----------");
        System.out.println("Имя заявки: " + tracker.findById(id).getName());
        System.out.println("Описание заявкаи : " + tracker.findById(id).getDesc());
    }

    /**
     * Метод реализует поиск заявки по Id.
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
        System.out.println("Меню.");
        System.out.println("0. Добавление новой заявки.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Замена заявки.");
        System.out.println("3. Удаление заявки.");
        System.out.println("4. Поиск заявки по Id.");
        System.out.println("5. Поиск заявки по имени.");
        System.out.println("6. Завершение работы программы.");

    }

    /**
     * Запускт программы.
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}