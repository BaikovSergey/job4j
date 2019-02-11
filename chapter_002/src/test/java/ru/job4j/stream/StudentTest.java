package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.02.19
 */
public class StudentTest {

    /**
     * Test levelOf.
     */
    @Test
    public void whenGetStudentsWithScoreHigherThenBoundThenListOfStudents() {
        Student test = new Student("Test", 0);
        Student student1 = new Student("Test Student One", 45);
        Student student2 = new Student(null, 0);
        Student student3 = new Student("Test Student Three", 78);
        Student student4 = new Student("Test Student Four", 38);
        Student student5 = new Student("Test Student Five", 92);
        Student student6 = new Student("Test Student Six", 65);
        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));
        List<Student> result = test.levelOf(studentList, 50);
        List<Student> expect = new ArrayList<>(Arrays.asList(student5, student3, student6));
        assertThat(result, is(expect));
    }

}