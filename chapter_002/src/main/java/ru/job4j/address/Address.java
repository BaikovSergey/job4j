package ru.job4j.address;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 05.02.19
 */
public class Address {
    /**
     * Хранит название горола.
     */
    private String city;
    /**
     * Хранит название улицы.
     */
    private String street;
    /**
     * Хранит номер дома.
     */
    private int home;
    /**
     * Хранит номер квартиры.
     */
    private int apartment;

    /**
     * Конструктор.
     * @param city город.
     * @param street улица.
     * @param home номер дома.
     * @param apartment номер квартиры.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
