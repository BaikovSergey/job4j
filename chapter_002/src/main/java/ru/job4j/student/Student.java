package ru.job4j.student;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 04.02.19
 */
public class Student {
    int score;

    /**
     * Конструктор.
     * @param score общий средний балл ученика.
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Getter.
     * @return Общий средний балл ученика.
     */
    public int getScore() {
        return score;
    }
}
