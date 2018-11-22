package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

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
}
