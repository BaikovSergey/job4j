package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.01.19
 */
public class User implements Comparable<User> {

    /**
     * Хранит имя пользователя.
     */
    private  String name;

    /**
     * Хранит номер паспорта пользователя.
     */
    private  String passport;

    /**
     * Конструктор
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int compareTo(User o) {
        return passport.compareTo(o.passport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
