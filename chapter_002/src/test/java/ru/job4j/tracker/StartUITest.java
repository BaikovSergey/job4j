package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker;
    private Item first;

    /**
     * Before выполняет метод, до запуска теста.
     */
    @Before
    public void loadOutput() {
        tracker = new Tracker();
        first = tracker.add(new Item("test name", "desc"));
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test findAllItems.
     */
    @Test
    public void whenTwoItemsInTrackerThenLengthIsTwo() {
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
        Input input = new StubInput(new String[]{"2", first.getId(), "test name two", "change", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name two"));
    }

    /**
     * Test deleteItem.
     */
    @Test
    public void whenDeleteItemThenOnlyOneItemLeft() {
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
        Input input = new StubInput(new String[]{"4", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test findItemByName.
     */
    @Test
    public void whenFindByNameThenReturnItemWithThatName() {
        Input input = new StubInput(new String[]{"5", first.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test showMenu.
     */
    @Test
    public void whenShowMenuThenPrintMenu() {
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
                            .append("\n6. Завершение работы программы.");

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
