package ru.job4j.student;


import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 04.02.19
 */
public class SchoolTest {

    /**
     * Test collect.
     */
    @Test
    public void whenFilteredByHighScoreThenOneStudent() {
        School school = new School();
        Student student1 = new Student(89);
        Student student2 = new Student(23);
        Student student3 = new Student(66);
        Student student4 = new Student(52);
        Student student5 = new Student(49);
        Student student6 = new Student(35);
        List<Student> class9A = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));
        List<Student> result = school.collect(class9A, School.highScore());
        List<Student> expect = new ArrayList<>(Collections.singletonList(student1));
        assertThat(result, is(expect));
    }

    /**
     * Test collect.
     */
    @Test
    public void whenFilteredByMidScoreThenTwoStudents() {
        School school = new School();
        Student student1 = new Student(89);
        Student student2 = new Student(23);
        Student student3 = new Student(66);
        Student student4 = new Student(52);
        Student student5 = new Student(49);
        Student student6 = new Student(35);
        List<Student> class9A = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));
        List<Student> result = school.collect(class9A, School.midScore());
        List<Student> expect = new ArrayList<>(Arrays.asList(student3, student4));
        assertThat(result, is(expect));
    }

    /**
     * Test collect.
     */
    @Test
    public void whenFilteredByLowScoreThenTwoStudents() {
        School school = new School();
        Student student1 = new Student(89);
        Student student2 = new Student(23);
        Student student3 = new Student(66);
        Student student4 = new Student(52);
        Student student5 = new Student(49);
        Student student6 = new Student(35);
        List<Student> class9A = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6));
        List<Student> result = school.collect(class9A, School.lowScore());
        List<Student> expect = new ArrayList<>(Arrays.asList(student2, student5, student6));
        assertThat(result, is(expect));
    }
}