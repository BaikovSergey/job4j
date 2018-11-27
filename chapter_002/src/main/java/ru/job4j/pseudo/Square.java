package ru.job4j.pseudo;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.11.18
 */
public class Square implements Shape {

    /**
     * Метод формирует псевдографику квадрата.
     * @return рисунок квадрата.
     */
    @Override
   public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("\n+  +");
        pic.append("\n+  +");
        pic.append("\n++++");
        return pic.toString();
    }
}
