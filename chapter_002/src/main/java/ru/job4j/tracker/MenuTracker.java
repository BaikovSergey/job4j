package ru.job4j.tracker;

import java.util.ArrayList;

public class MenuTracker {

    /**
     * хранит ссылку на объект.
     */
    private Input input;

    /**
     * хранит ссылку на объект.
     */
    private Tracker tracker;

    /**
     * хранит количестов пунктов меню.
     */
    private int position = 0;

    private StartUI ui;

    /**
     * хранит ссылку на массив типа UserAction.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLenght() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавить новую заявку."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new MenuTracker.EditItem(2, "Заменить заявку."));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по Id."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(6, "Завершить работу программы.", ui));
    }

    public void addAction(UserAction action) {
        //this.actions[position++] = action;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println(new StringBuilder()
                .append("Меню."));
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
        }
    }

    public class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("------------ Вывод всех заявок --------------");
                ArrayList<Item> founds = tracker.findAll();
                for (int i = 0; i < founds.size(); i++) {
                    System.out.println(founds.get(i).toString());
                    System.out.println(System.lineSeparator());
                }
            }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Замена заявки --------------");
            String id = input.ask("Введите Id заявки, котрую хотите заменить: ");
            String name = input.ask("Введите имя новой заявки: ");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка успешно заменена -----------");
                System.out.println("Имя заявки: " + name);
                System.out.println("Id заявки: " + id);
            } else {
                System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
            }
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите Id заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка с Id: " + id + " удалена -----------");
            } else {
                System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
            }
        }
    }

    public class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id заявки :");
            Item finds = tracker.findById(id);
            if (finds != null && finds.getId().equals(id)) {
                System.out.println("------------ Заявка с Id: " + id + " -----------");
                System.out.println(finds.toString());
            } else {
                System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
            }
        }
    }

    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            System.out.println("------------ Заявки с именем: " + name + " -----------");
            for (int i = 0; i < tracker.findByName(name).size(); i++) {
                System.out.println("Id заявки: " + tracker.findByName(name).get(i));
                System.out.println("Описание заявки: " + tracker.findByName(name).get(i));
            }
        }
    }

    public class ExitProgram extends BaseAction {
        private StartUI startUI;

        public ExitProgram(int key, String name, StartUI startUI) {
            super(key, name);
            this.startUI = startUI;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Завершение работы программы --------------");
            startUI.exit();
        }
    }
}
