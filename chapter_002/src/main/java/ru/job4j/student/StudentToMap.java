package ru.job4j.student;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 04.02.19
 */
public class StudentToMap {
    /**
     * Хранит общий средний бал ученика.
     */
    private int score;
    /**
     * Хранит общий средний бал ученика.
     */
    private String name;
    /**
     * Хранит общий средний бал ученика.
     */
    private String surname;

    /**
     * Конструктор.
     * @param score общий средний балл ученика.
     */
    public StudentToMap(int score, String name, String surname) {
        this.score = score;
        this.name = name;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
