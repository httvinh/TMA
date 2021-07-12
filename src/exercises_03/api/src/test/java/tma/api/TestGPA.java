package tma.api;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import tma.api.entity.Student;
import tma.api.entity.Subject;

public class TestGPA {
    Student student = new Student();
    Set<Subject> subjects = new HashSet<Subject>();

    @Before
    public void beforeTestGPA() {
        subjects.add(new Subject("Van", 7));
        subjects.add(new Subject("Toan", 8));
        subjects.add(new Subject("Lý", 9));
        student.setSubjects(subjects);
    }

    @Test
    public void testCalculateGPA() {
        float gpa = student.calculateGPA();
        assertEquals(8, gpa, 0.0);
    }
}
