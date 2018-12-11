package ru.job4j.search;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.12.18
 */
public class Person {

    /**
     * Хранит имя.
     */
    private String name;

    /**
     * Хранит фамилию.
     */
    private String surname;

    /**
     * Хранит номер телефона.
     */
    private String phone;

    /**
     * Хранит адрес.
     */
    private String address;

    /**
     * Конструктор.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
