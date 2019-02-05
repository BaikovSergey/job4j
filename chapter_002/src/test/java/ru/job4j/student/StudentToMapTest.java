package ru.job4j.student;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 05.02.19
 */
public class StudentToMapTest {
    /**
     * Test collectMap.
     */
    @Test
    public void whenListOfStudentsThenMapOfStudents() {
        School school = new School();
        StudentToMap student1 = new StudentToMap(87, "Vladislav", "Baikov");
        StudentToMap student2 = new StudentToMap(86, "Segey", "Smirnov");
        List<StudentToMap> testList = new ArrayList<>(Arrays.asList(student1, student2));
        Map<String, StudentToMap> expect = new HashMap<>();
        expect.put(student1.getSurname(), student1);
        expect.put(student2.getSurname(), student2);
        Map<String, StudentToMap> result = school.collectMap(testList);
        assertThat(result, is(expect));
    }

}