package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.12.18
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

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
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().contains(key)
                    || persons.get(i).getSurname().contains(key)
                    || persons.get(i).getAddress().contains(key)
                    || persons.get(i).getPhone().contains(key)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }
}
