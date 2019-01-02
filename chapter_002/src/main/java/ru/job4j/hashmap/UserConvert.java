package ru.job4j.hashmap;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 02.01.19
 */
public class UserConvert {

    /**
     * Метод конвертирует List в HashMap
     * @param list литс из объектов User
     * @return HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User user : list) {
            hashMap.put(user.getId(), user);
        }
    return hashMap;
    }
}
