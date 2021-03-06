package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.12.18
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
                this.persons
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getName().equals(key)
                || s.getSurname().equals(key)
                || s.getAddress().equals(key)
                || s.getPhone().equals(key))
                .forEach(result :: add);
        return result;
    }
}
