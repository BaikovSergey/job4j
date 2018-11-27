package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    /**
     * хранит ссылку на объект .
     */
    private Input input;
    /**
     * хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

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

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление новой заявки."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new MenuTracker.EditItem(2, "Замена заявки."));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удаление заявки."));
        this.actions.add(new FindItemById(4, "Поиск заявки по Id."));
        this.actions.add(new FindItemsByName(5, "Поиск заявки по имени."));
        this.actions.add(new ExitProgram(6, "Завершение работы программы."));
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
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public class AddItem implements UserAction {

        @Override
        public int key() {
        return ADD;
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

        @Override
        public String info() {
            return "Добавление новой заявки.";
        }
    }

    public class ShowItems implements UserAction {

        @Override
        public int key() {
            return FINDALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            Item[] founds = tracker.findAll();
            for (int i = 0; i < founds.length; i++) {
                System.out.println(founds[i].toString());
                System.out.println(System.lineSeparator());
        }
    }

        @Override
        public String info() {
            return "Показать все заявки";
        }
    }

    public class EditItem implements UserAction {

        @Override
        public int key() {
            return REPLACE;
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
            } else  {
                System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
            }
        }

        @Override
        public String info() {
            return "Заменить заявку";
        }
    }

    public class DeleteItem implements UserAction {

        @Override
        public int key() {
            return DELETE;
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

        @Override
        public String info() {
            return "Удалить заявку";
        }
    }

    public class FindItemById implements UserAction {

        @Override
        public int key() {
            return FINDBYID;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id заявки :");
            Item founds = tracker.findById(id);
            if (founds != null && founds.getId().equals(id)) {
                System.out.println("------------ Заявка с Id: " + id + " -----------");
                System.out.println(founds.toString());
            } else {
                System.out.println("------------ Ошибка. Заявка с Id: " + id + " не найдена -----------");
            }
        }

        @Override
        public String info() {
            return "Найти заявку по Id";
        }
    }

    public class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return FINDBYNAME;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            System.out.println("------------ Заявки с именем: " + name + " -----------");
            for (int i = 0; i < tracker.findByName(name).length; i++) {
                System.out.println("Id заявки: " + tracker.findByName(name)[i].getId());
                System.out.println("Описание заявки: " + tracker.findByName(name)[i].getDesc());
            }
        }

        @Override
        public String info() {
            return "Найти заявку по имени";
        }
    }

    public class ExitProgram implements UserAction {

        @Override
        public int key() {
            return EXIT;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Завершение работы программы --------------");
            // заполнить
        }

        @Override
        public String info() {
            return "Завершение работы программы.";
        }
    }
}
