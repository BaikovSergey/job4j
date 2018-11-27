package ru.job4j.loop;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 27.10.18
 */
public class Board {

    /**
     * Постройка шахматной доски в псевдографике.
     * @param width ширина доски.
     * @param height высота доски.
     * @return рисунок шахматноц доски.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
             screen.append(ln);
        }
        return screen.toString();
    }
}
