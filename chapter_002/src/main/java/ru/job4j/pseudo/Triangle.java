package ru.job4j.pseudo;

public class Triangle implements Shape {

    /**
     * Метод формирует псевдографику треугольника.
     * @return рисунок треугольника.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +");
        pic.append("\n  +++");
        pic.append("\n +++++");
        pic.append("\n+++++++");
        return pic.toString();
    }
}
