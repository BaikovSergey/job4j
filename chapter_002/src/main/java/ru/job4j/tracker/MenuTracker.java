package ru.job4j.tracker;

public class MenuTracker {

    /**
     * хранит ссылку на объект .
     */
    private Input input;
    /**
     * хранит ссылку на объект .
     */
    private Tracker tracker;

    private StartUI ui;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];

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
        return this.actions.length;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemsByName();
        this.actions[6] = new ExitProgram(ui);
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
    public class AddItem implements UserAction {

        @Override
        public int key() {
        return 0;
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
            return "0. Добавить новую заявку.";
        }
    }

    public class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
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
            return "1. Показать все заявки.";
        }
    }

    public class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
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
            return "2. Заменить заявку.";
        }
    }

    public class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
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
            return "3. Удалить заявку.";
        }
    }

    public class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
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
            return "4. Найти заявку по Id.";
        }
    }

    public class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
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
            return "5. Найти заявку по имени.";
        }
    }

    public class ExitProgram implements UserAction {
        private final StartUI ui;

        public ExitProgram(StartUI ui) {
            this.ui = ui;
        }


        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Завершение работы программы --------------");
            this.ui.exit();
        }

        @Override
        public String info() {
            return "6. Завершить работу программы.";
        }
    }
}
