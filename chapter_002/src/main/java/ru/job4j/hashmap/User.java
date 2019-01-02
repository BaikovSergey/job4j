package ru.job4j.hashmap;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 02.01.19
 */
public class User {

    /**
     * Хранит id
     */
    private int id;

    /**
     * Хранит имя
     */
    private String name;

    /**
     * Хранит название города
     */
    private  String city;

    /**
     * конструктор
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
