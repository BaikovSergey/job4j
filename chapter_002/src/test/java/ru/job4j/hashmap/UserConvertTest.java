package ru.job4j.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 02.01.19
 */
public class UserConvertTest {

    /**
     * Test process
     */
    @Test
    public void when1ListThen1HashMap() {
        UserConvert convert = new UserConvert();
        User josehp = new User(1, "Joseph", "London");
        List<User> list = new ArrayList<>();
        list.add(josehp);
        HashMap<Integer, User> result = convert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, josehp);
        assertThat(result, is(expect));
    }
}