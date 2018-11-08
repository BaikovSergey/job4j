package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 27.10.18
 */
public class Paint {

    /**
     * Построение правой части пирпмиды в псевдографике.
     * @param height высота пирамиды.
     * @return рисунок правой части пирамиды.
     */
    public String rightTrl(int height) {
                    return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= column
            );
        }

    /**
     * Построение левой части пирпмиды в псевдографике.
     * @param height высота пирамиды.
     * @return рисунок левой части пирамиды.
     */
        public String leftTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= height - column - 1
            );
        }

    /**
     * Построение пирпмиды по центру в псевдографике.
     * @param height высота пирамиды.
     * @return рисунок пирамиды.
     */
        public String pyramid(int height) {
            return this.loopBy(
                    height,
                    2 * height - 1,
                    (row, column) -> row >= height - column - 1 && row + height - 1 >= column
            );
        }

    /**
     * Построение пирпмиды в псевдографике.
     * @param height высота пирамиды.
     * @param weight высота пирамиды.
     * @return рисунок пирамиды.
     */
        private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
            StringBuilder screen = new StringBuilder();
            for (int row = 0; row != height; row++) {
                for (int column = 0; column != weight; column++) {
                    if (predict.test(row, column)) {
                        screen.append("^");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(System.lineSeparator());
            }
            return screen.toString();
        }
    }
