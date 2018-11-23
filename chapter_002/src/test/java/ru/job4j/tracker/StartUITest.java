package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Before выполняет метод, до запуска теста.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * After выполняет метод, после запуска теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test createItem.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test findAllItems.
     */
    @Test
    public void whenTwoItemsInTrackerThenLengthIsTwo() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test name", "desc"));
        Item second = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }

    /**
     * Test replaceItem.
     */
    @Test
    public void whenUserReplaceItemThenTrackerHasThatItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name two", "change", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name two"));
    }

    /**
     * Test deleteItem.
     */
    @Test
    public void whenDeleteItemThenOnlyOneItemLeft() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test name", "desc"));
        Item second = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(second));
    }

    /**
     * Test findItemById.
     */
    @Test
    public void whenFindByIdThenReturnItemWithThatId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test findItemByName.
     */
    @Test
    public void whenFindByNameThenReturnItemWithThatName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test showMenu.
     */
    @Test
    public void whenShowMenuThenPrintMenu() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test name", "desc"));
        String id = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder menu = new StringBuilder()
                            .append("Меню.\r")
                            .append("\n0. Добавление новой заявки.\r")
                            .append("\n1. Показать все заявки.\r")
                            .append("\n2. Замена заявки.\r")
                            .append("\n3. Удаление заявки.\r")
                            .append("\n4. Поиск заявки по Id.\r")
                            .append("\n5. Поиск заявки по имени.\r")
                            .append("\n6. Завершение работы программы.\r");

        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu + "\r")
                        .append("\n------------ Вывод всех заявок --------------\r")
                        .append("\nИмя заявки: test name\r")
                        .append("\nId заявки: " + id + "\r")
                        .append("\nОписание заявки: desc\r")
                        .append("\n \r")
                        .append("\n" + menu + "\r")

                )
        );
    }
}
