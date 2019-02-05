package ru.job4j.address;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 05.02.19
 */
public class Profile {
    private Address address;

    /**
     * Конструктор.
     * @param address Адрес пользователя.
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Метод составляет список адресов из профилей пользователей.
     * @param profiles список профилей пользователей.
     * @return список адресов пользователей.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.address)
                .collect(Collectors.toList());
    }
}


