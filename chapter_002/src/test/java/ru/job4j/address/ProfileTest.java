package ru.job4j.address;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 05.02.19
 */
public class ProfileTest {

    /**
     * Test collect.
     */
    @Test
    public void whenSearchFoAddressThenListOfAddresses() {
        Address address1 = new Address("Moscow", "Pionerskaya st", 3, 1);
        Address address2 = new Address("Tokyo", "Shibuya", 32, 16);
        Address address3 = new Address("New York", "Greenroad st", 6, 2);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        List<Profile> profiles = new ArrayList<>(Arrays.asList(profile1, profile2, profile3));
        Profile test = new Profile(null);
        List<Address> result = test.collect(profiles);
        List<Address> expect = new ArrayList<>(Arrays.asList(address1, address2, address3));
        assertThat(result, is(expect));
    }
}